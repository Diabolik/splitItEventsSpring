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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.splitit.events.entity.ThemeEntity;
import com.splitit.events.interfaces.IModel;

@SuppressWarnings("serial")
@Entity
public class Theme extends BaseObject implements IModel {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String urlCover;
	
	@Column(nullable = false)
	private String urlBackground;
	
	@Column(nullable = false)
	private String colorName;
	
	@Column(nullable = false)
	private String colorDescription;
	
	@Column(nullable = false)
	private String colorLink;
	
	@Column(nullable = false)
	private String colorGuests;
	
	@Column(nullable = false)
	private String  colorSection1;
	
	@Column(nullable = false)
	private String colorSection2;
	
	@Override
	public Object toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		ThemeEntity entity = mapper.convertValue(this, ThemeEntity.class);
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the urlCover
	 */
	public String getUrlCover() {
		return urlCover;
	}

	/**
	 * @param urlCover the urlCover to set
	 */
	public void setUrlCover(String urlCover) {
		this.urlCover = urlCover;
	}

	/**
	 * @return the urlBackground
	 */
	public String getUrlBackground() {
		return urlBackground;
	}

	/**
	 * @param urlBackground the urlBackground to set
	 */
	public void setUrlBackground(String urlBackground) {
		this.urlBackground = urlBackground;
	}

	/**
	 * @return the colorName
	 */
	public String getColorName() {
		return colorName;
	}

	/**
	 * @param colorName the colorName to set
	 */
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	/**
	 * @return the colorDescription
	 */
	public String getColorDescription() {
		return colorDescription;
	}

	/**
	 * @param colorDescription the colorDescription to set
	 */
	public void setColorDescription(String colorDescription) {
		this.colorDescription = colorDescription;
	}

	/**
	 * @return the colorLink
	 */
	public String getColorLink() {
		return colorLink;
	}

	/**
	 * @param colorLink the colorLink to set
	 */
	public void setColorLink(String colorLink) {
		this.colorLink = colorLink;
	}

	/**
	 * @return the colorGuests
	 */
	public String getColorGuests() {
		return colorGuests;
	}

	/**
	 * @param colorGuests the colorGuests to set
	 */
	public void setColorGuests(String colorGuests) {
		this.colorGuests = colorGuests;
	}

	/**
	 * @return the colorSection1
	 */
	public String getColorSection1() {
		return colorSection1;
	}

	/**
	 * @param colorSection1 the colorSection1 to set
	 */
	public void setColorSection1(String colorSection1) {
		this.colorSection1 = colorSection1;
	}

	/**
	 * @return the colorSection2
	 */
	public String getColorSection2() {
		return colorSection2;
	}

	/**
	 * @param colorSection2 the colorSection2 to set
	 */
	public void setColorSection2(String colorSection2) {
		this.colorSection2 = colorSection2;
	}
}
