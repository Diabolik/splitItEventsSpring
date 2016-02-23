/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splitit.events.entity.GalleryItemEntity;
import com.splitit.events.interfaces.IModel;

@SuppressWarnings("serial")
@Entity
public class GalleryItem extends BaseObject implements IModel {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String comment;
	
	@ManyToOne
	private Event event;
	
	@Override
	public Object toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		GalleryItemEntity entity = mapper.convertValue(this, GalleryItemEntity.class);
		return entity;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
