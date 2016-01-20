package com.splitit.events.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ZipCode {

	@Id
	private int id;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
}
