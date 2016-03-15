/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splitit.events.domain.Event;
import com.splitit.events.domain.Theme;
import com.splitit.events.entity.EventEntity;
import com.splitit.events.entity.ThemeEntity;
import com.splitit.events.exception.EventsErrorCode;
import com.splitit.events.services.EventService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(description = "Insert a new user", value = "")
public class EventController {

	private final static Log log = LogFactory.getLog(EventController.class);

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieve the Event by Id", notes = "Retrieve the Event by Id")
	public ResponseEntity<EventEntity> findById(@RequestParam("id") long id) {
		ResponseEntity<EventEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		
		Event event = validateThemeNotExists(id, responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<EventEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		EventEntity entity = (EventEntity) event.toEntity();
		response = new ResponseEntity<EventEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieve all the events by owner", notes = "Retrieve all the events by owner")
	public List<EventEntity> findEventsByOwner() {
		ArrayList<EventEntity> result = new ArrayList<EventEntity>();
		List<Event> events = eventService.findByOwner();
		events.forEach(x -> {
			ThemeEntity entity = (EventEntity) x.toEntity();
			result.add(entity);
		});
		return result;
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	@ApiOperation(value = "Save the theme provided", notes = "Save the theme provided")
	public ResponseEntity<EventEntity> save(@RequestBody EventEntity entity) {
		ResponseEntity<EventEntity> response = null;
		
		Event event = (Event) entity.toModel();
		entity = (EventEntity) eventService.save(event).toEntity();

		response = new ResponseEntity<EventEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.PUT)
	@ApiOperation(value = "Update the theme provided", notes = "Update the theme provided")
	public ResponseEntity<EventEntity> update(@RequestBody EventEntity entity) {
		ResponseEntity<EventEntity> response = null;
		
		Event event = (Event) entity.toModel();
		entity = (EventEntity) eventService.save(event).toEntity();

		response = new ResponseEntity<EventEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Verify if the event is not used.
	 * 
	 * @param theme
	 * @param headers
	 */
	private Event validateThemeNotExists(long id, HttpHeaders headers) {
		Event theme = null;
		
		if (!eventService.exists(id)) {
			EventsErrorCode managedError = EventsErrorCode.EVENT_NOT_FOUND;
			log.error(managedError);
			headers.add("EVENT_NOT_FOUND", managedError.toString());
		} else {
			theme = eventService.findById(id);
		}
		return theme;
	}

}