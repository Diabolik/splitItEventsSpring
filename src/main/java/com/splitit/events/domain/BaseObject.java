/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseObject implements Serializable {

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date dateCreated;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date dateUpdated;

	@Column(nullable = false, length = 50)
	private String dataOrigin;
	@Column(nullable = false)
	private String createdBy;
	@Column(nullable = false)
	private String updatedBy;
	@Version
	private Long version;

	public void clearValues() {
		dateCreated = null;
		dateUpdated = null;
		dataOrigin = null;
		createdBy = null;
		updatedBy = null;
	}
	
	@PreUpdate
	@PrePersist
	public void prePersistValues() {

		if (this.dateCreated == null) {
			this.dateCreated = new Date(System.currentTimeMillis());
		}

		this.dateUpdated = new Date(System.currentTimeMillis());

		if (this.dataOrigin == null) {
			this.dataOrigin = "Split It Engine";
		}
		if (this.createdBy == null) {
			this.createdBy = "Split It Engine";
		}
		if (this.updatedBy == null) {
			this.updatedBy = "Split It Engine";
		}
	}

	/**
	 * @return the date created
	 */
	public Date getDateCreated() {

		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the date created to set
	 */
	public void setDateCreated(Date dateCreated) {

		this.dateCreated = dateCreated;
	}

	/**
	 * @return the last updated
	 */
	public Date getDateUpdated() {

		return dateUpdated;
	}

	/**
	 * @param dateUpdated
	 *            the date updated to set
	 */
	public void setDateUpdated(Date dateUpdated) {

		this.dateUpdated = dateUpdated;
	}

	/**
	 * @return the dataOrigin
	 */
	public String getDataOrigin() {

		return dataOrigin;
	}

	/**
	 * @param dataOrigin
	 *            the data origin to set
	 */
	public void setDataOrigin(String dataOrigin) {

		this.dataOrigin = dataOrigin;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
}
