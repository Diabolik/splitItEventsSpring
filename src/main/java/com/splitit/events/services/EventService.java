/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitit.events.domain.Event;
import com.splitit.events.jpa.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	/**
	 * Find the Event by Id
	 * 
	 * @param id
	 * @return
	 */
	public Event findById(long id) {
		return eventRepository.findOne(id);
	}
	
	/**
	 * Return a list with all the Events
	 * 
	 * @return
	 */
	public List<Event> findByOwner() {
		return eventRepository.findByOwner();
	}

	/**
	 * Validate event existence
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(long id) {
		return eventRepository.exists(id);
	}
	
	/**
	 * Saves an Event.
	 * 
	 * @param user
	 *            Event to save
	 * 
	 * @return Saved theme
	 */
	public Event save(Event event) {
		Event savedEvent = eventRepository.save(event);
		return savedEvent;
	}
	
	/**
	 * Updates an Event.
	 * 
	 * @param event
	 *            Event to save
	 * 
	 * @return Saved theme
	 */
	public Event update(Event event) {
		Event savedEvent = eventRepository.save(event);
		return savedEvent;
	}
}