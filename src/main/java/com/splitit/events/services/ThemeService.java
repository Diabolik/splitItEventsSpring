/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitit.events.domain.Theme;
import com.splitit.events.jpa.ThemeRepository;

@Service
public class ThemeService {

	@Autowired
	private ThemeRepository themeRepository;
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	
	/**
	 * Find the Theme by Id
	 * 
	 * @param id
	 * @return
	 */
	public Theme findById(long id) {
		return themeRepository.findOne(id);
	}
	
	/**
	 * Return a list with all the Themes
	 * 
	 * @return
	 */
	public List<Theme> findAll() {
		return themeRepository.findAll();
	}

	/**
	 * Validate theme existence
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(long id) {
		return themeRepository.exists(id);
	}
	
	/**
	 * Saves an Theme.
	 * 
	 * @param user
	 *            Theme to save
	 * 
	 * @return Saved theme
	 */
	public Theme save(Theme theme) {
		Theme savedTheme = themeRepository.save(theme);
		return savedTheme;
	}
}