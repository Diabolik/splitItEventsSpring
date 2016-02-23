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
import com.splitit.events.entity.AddressEntity;
import com.splitit.events.interfaces.IModel;

@SuppressWarnings("serial")
@Entity
public class Address extends BaseObject implements IModel {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String suburb;
	
	@Column(nullable = false)
	private String extNumber;
	
	@Column(nullable = false)
	private String zipCode;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = true)
	private String intNumber;
	
	@Column(nullable = true)
	private String reference;
	
	@Column(nullable = true)
	private Float geoLat;
	
	@Column(nullable = true)
	private Float geoLon;
	
	@ManyToOne
	private User user;
	
	@Override
	public Object toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		AddressEntity entity = mapper.convertValue(this, AddressEntity.class);
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * @return the extNumber
	 */
	public String getExtNumber() {
		return extNumber;
	}

	/**
	 * @param extNumber the extNumber to set
	 */
	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the intNumber
	 */
	public String getIntNumber() {
		return intNumber;
	}

	/**
	 * @param intNumber the intNumber to set
	 */
	public void setIntNumber(String intNumber) {
		this.intNumber = intNumber;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the geoLat
	 */
	public Float getGeoLat() {
		return geoLat;
	}

	/**
	 * @param geoLat the geoLat to set
	 */
	public void setGeoLat(Float geoLat) {
		this.geoLat = geoLat;
	}

	/**
	 * @return the geoLon
	 */
	public Float getGeoLon() {
		return geoLon;
	}

	/**
	 * @param geoLon the geoLon to set
	 */
	public void setGeoLon(Float geoLon) {
		this.geoLon = geoLon;
	}
}