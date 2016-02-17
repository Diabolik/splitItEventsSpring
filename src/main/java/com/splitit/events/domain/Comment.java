package com.splitit.events.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Comment extends BaseObject {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String comment;
	
	@OneToOne
	private User owner;
	
	@ManyToOne
	private Event event;
}
