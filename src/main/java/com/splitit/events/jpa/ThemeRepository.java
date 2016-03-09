/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitit.events.domain.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
	
}
