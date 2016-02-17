package com.splitit.events.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class GalleryItem extends BaseObject {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String comment;
	
	@ManyToOne
	private Event event;
	
}
