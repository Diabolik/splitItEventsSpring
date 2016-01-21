/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitit.events.domain.ZipCode;
import com.splitit.events.jpa.ZipCodeRepository;

@Service
public class ZipCodeService {

	@Autowired
	private ZipCodeRepository zipCodeRepository;
	
	public ZipCode findById(int id) {
		ZipCode agreement = zipCodeRepository.findOne(id);
		return agreement;
	}

	public boolean exists(int id) {
		return zipCodeRepository.exists(id);
	}
}