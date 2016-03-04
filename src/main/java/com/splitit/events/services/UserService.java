/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitit.events.domain.User;
import com.splitit.events.jpa.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	/**
	 * Find User by email
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}
	
	/**
	 * Find User by nickname
	 * 
	 * @param nickname
	 * @return
	 */
	public User findByNickname(String nickname) {
		User user = userRepository.findByNickname(nickname);
		return user;
	}
	
	/**
	 * Returns a detached User. This method is used for update method
	 * 
	 * @param id
	 * @return
	 */
	public User findEquivalencyDetached(long id) {
		User user = userRepository.findOne(id);
		entityManager.detach(user);
		return user;
	}

	/**
	 * Validate user existence
	 * 
	 * @param equivalencyId
	 * @return
	 */
	public boolean exists(long id) {
		return userRepository.exists(id);
	}
	
	/**
	 * Saves an user.
	 * 
	 * @param user
	 *            User to save
	 * 
	 * @return Saved user
	 */
	public User save(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}