/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.exception;

public enum EventsErrorCode {

	USER_NOT_FOUND(001, "USER_NOT_FOUND", "The user is not found in the database."),
	ZIPCODE_NOT_FOUND(031, "ZIPCODE_NOT_FOUND", "The zip code is not found in the database. Using ID: "),
	EVENT_NOT_FOUND(041, "EVENT_NOT_FOUND", "The event is not found in the database. Using ID: "),
	THEME_NOT_FOUND(071, "THEME_NOT_FOUND", "The theme is not found in the database. Using ID: ");

	private int errorType;
	private String label;
	private String description;
	
	private EventsErrorCode(int errorType, String label, String description)
	{
		this.errorType = errorType;
		this.label = label;
		this.description = description;
	}
	
	public int getType(){
		return errorType; 
	}
	
	public String getLabel(){
		return label;
	}
	
	public String getDescription(){
		return description;
	}
}
