/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.splitit.events.domain.User;
import com.splitit.events.entity.UserEntity;
import com.splitit.events.exception.EventsErrorCode;
import com.splitit.events.services.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(description = "Insert a new user", value = "")
public class UserController {

	private final static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	@ApiOperation(value = "Search the city and the state by the zipcode", notes = "Search the city and the state by the zipcode")
//	public ResponseEntity<ZipCodeEntity> findById(@PathVariable("id") int id) {
//		EventsErrorCode managedError = EventsErrorCode.ZIPCODE_NOT_FOUND;
//		ResponseEntity<ZipCodeEntity> response = null;
//
//		if (!userService.exists(id)) {
//			log.error(managedError.getDescription() + id);
//			response = new ResponseEntity<ZipCodeEntity>(HttpStatus.NOT_FOUND);
//			return response;
//		}
//
//		ZipCodeEntity entity = (ZipCodeEntity) userService.findById(id).toEntity();
//		response = new ResponseEntity<ZipCodeEntity>(entity, HttpStatus.OK);
//		return response;
//	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ApiOperation(value = "Save the user provided", notes = "Save the user provided")
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity) {
		ResponseEntity<UserEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		
		validateEmailExists(userEntity.getEmail(), responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<UserEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}
		
		validateNicknameExists(userEntity.getNickname(), responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<UserEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		User user = (User) userEntity.toModel();
		userEntity = (UserEntity) userService.save(user).toEntity();

		response = new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Verify if the email is used
	 * 
	 * @param email
	 * @param headers
	 */
	private void validateEmailExists(String email, HttpHeaders headers) {
		if (userService.findByEmail(email) != null) {
			EventsErrorCode managedError = EventsErrorCode.USER_FOUND_EMAIL;
			log.error(managedError);
			headers.add("USER_FOUND_EMAIL", managedError.toString());
		}
	}
	
	/**
	 * Verify if the nickname is used
	 * 
	 * @param nickname
	 * @param headers
	 */
	private void validateNicknameExists(String nickname, HttpHeaders headers) {
		if (userService.findByNickname(nickname) != null) {
			EventsErrorCode managedError = EventsErrorCode.USER_FOUND_NICKNAME;
			log.error(managedError);
			headers.add("USER_FOUND_EMAIL", managedError.toString());
		}
	}
}