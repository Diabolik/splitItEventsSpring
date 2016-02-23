/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.entity;

import java.sql.Date;
import java.util.Set;

public class EventEntity {
	private Long id;
	
	private String name;
	
	private String description;
	
	private String place;
	
	private boolean visibility;
	
	private ThemeEntity theme;
	
	private UserEntity owner;
	
	private Set<CommentEntity> comments;
	
	private Set<GalleryItemEntity> gallery;
	
	private Date startDate;
	
	private Date endDate;

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
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the visibility
	 */
	public boolean isVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the theme
	 */
	public ThemeEntity getTheme() {
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(ThemeEntity theme) {
		this.theme = theme;
	}

	/**
	 * @return the owner
	 */
	public UserEntity getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	/**
	 * @return the comments
	 */
	public Set<CommentEntity> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}

	/**
	 * @return the gallery
	 */
	public Set<GalleryItemEntity> getGallery() {
		return gallery;
	}

	/**
	 * @param gallery the gallery to set
	 */
	public void setGallery(Set<GalleryItemEntity> gallery) {
		this.gallery = gallery;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
