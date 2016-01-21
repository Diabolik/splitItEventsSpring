/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitit.events.domain.ZipCode;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Integer> {

}
