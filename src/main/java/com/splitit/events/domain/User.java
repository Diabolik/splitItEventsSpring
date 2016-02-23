/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splitit.events.entity.UserEntity;
import com.splitit.events.interfaces.IModel;

@SuppressWarnings("serial")
@Entity
public class User extends BaseObject implements IModel {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String nickname;
	
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

	@Override
	public Object toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		UserEntity entity = mapper.convertValue(this, UserEntity.class);
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the fbId
	 */
	public Long getFbId() {
		return fbId;
	}

	/**
	 * @param fbId the fbId to set
	 */
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the addreses
	 */
	public Set<Address> getAddreses() {
		return addreses;
	}

	/**
	 * @param addreses the addreses to set
	 */
	public void setAddreses(Set<Address> addreses) {
		this.addreses = addreses;
	}	
}