/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitit.events.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	
	public List<Event> findByOwner();
}
