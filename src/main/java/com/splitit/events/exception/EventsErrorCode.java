/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.exception;

public enum EventsErrorCode {
	//Users
	USER_NOT_FOUND(001, "USER_NOT_FOUND", "The user is not found in the database."),
	USER_FOUND_EMAIL(002, "USER_FOUND_EMAIL", "This email is already used. Please Verify"),
	USER_FOUND_NICKNAME(002, "USER_FOUND_EMAIL", "This nickname is already used. Please Verify"),

	//ZipCode
	ZIPCODE_NOT_FOUND(031, "ZIPCODE_NOT_FOUND", "The zip code is not found in the database. Using ID: "),

	//Events
	EVENT_NOT_FOUND(041, "EVENT_NOT_FOUND", "The event is not found in the database. Using ID: "),
	
	//Theme
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
	
	@Override
	public String toString() {
		return getDescription();
	}
}
