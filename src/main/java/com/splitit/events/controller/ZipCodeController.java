/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.splitit.events.entity.ZipCodeEntity;
import com.splitit.events.exception.EventsErrorCode;
import com.splitit.events.services.ZipCodeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(description = "Finds the city and state using the zip code", value = "")
public class ZipCodeController {

	private final static Log log = LogFactory.getLog(ZipCodeController.class);

	@Autowired
	private ZipCodeService zipCodeService;

	@RequestMapping(value = "/zipcodes/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Search the city and the state by the zipcode", notes = "Search the city and the state by the zipcode")
	public ResponseEntity<ZipCodeEntity> findById(@PathVariable("id") int id) {
		EventsErrorCode managedError = EventsErrorCode.ZIPCODE_NOT_FOUND;
		ResponseEntity<ZipCodeEntity> response = null;

		if (!zipCodeService.exists(id)) {
			log.error(managedError.getDescription() + id);
			response = new ResponseEntity<ZipCodeEntity>(HttpStatus.NOT_FOUND);
			return response;
		}

		ZipCodeEntity entity = (ZipCodeEntity) zipCodeService.findById(id).toEntity();
		response = new ResponseEntity<ZipCodeEntity>(entity, HttpStatus.OK);
		return response;
	}
}