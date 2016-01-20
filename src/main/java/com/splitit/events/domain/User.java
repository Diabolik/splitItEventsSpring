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

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = true)
	private String password;
	
	@Column(nullable = true)
	private Date birthday;
	
	@Column(nullable = true)
	private Long fbId;
	
	@Column(nullable = true)
	private String image;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Address> addreses;
}
