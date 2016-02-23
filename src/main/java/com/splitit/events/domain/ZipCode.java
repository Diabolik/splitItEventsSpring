/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splitit.events.entity.ZipCodeEntity;
import com.splitit.events.interfaces.IModel;

@SuppressWarnings("serial")
@Entity
public class ZipCode extends BaseObject implements IModel {
	@Id
	private int id;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Override
	public Object toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		ZipCodeEntity entity = mapper.convertValue(this, ZipCodeEntity.class);
		return entity;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
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
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}