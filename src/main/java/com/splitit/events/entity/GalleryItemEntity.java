/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.entity;


public class GalleryItemEntity {
	private Long id;
	
	private String comment;
	
	private EventEntity event;

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
	public EventEntity getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(EventEntity event) {
		this.event = event;
	}
	
	
}
