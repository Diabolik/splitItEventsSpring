package com.splitit.events.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Event extends BaseObject{
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private String place;
	
	@Column(nullable = false)
	private boolean visibility;
	
	@OneToOne
	private Theme theme;
	
	@OneToOne
	@JsonIgnore
	private User owner;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "event")
	private Set<Comment> comments;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "event")
	private Set<GalleryItem> gallery;
	
	@Column(nullable = true)
	private Date startDate;
	
	@Column(nullable = true)
	private Date endDate;
}
