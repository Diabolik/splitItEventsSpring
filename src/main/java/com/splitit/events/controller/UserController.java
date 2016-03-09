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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splitit.events.domain.User;
import com.splitit.events.entity.UserEntity;
import com.splitit.events.exception.EventsErrorCode;
import com.splitit.events.services.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(description = "User Model API", value = "")
public class UserController {

	private final static Log log = LogFactory.getLog(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/email", method = RequestMethod.POST)
	@ApiOperation(value = "Search the user by email", notes = "Search the user by email")
	public ResponseEntity<UserEntity> findByEmail(@RequestParam("email") String email) {
		ResponseEntity<UserEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		
		User user = validateEmailNotExists(email, responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<UserEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		UserEntity entity = (UserEntity) user.toEntity();
		response = new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/users/nickname", method = RequestMethod.POST)
	@ApiOperation(value = "Search the user by email", notes = "Search the user by email")
	public ResponseEntity<UserEntity> findByNickname(@RequestParam("nickname") String nickname) {
		ResponseEntity<UserEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		
		User user = validateNicknameNotExists(nickname, responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<UserEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		UserEntity entity = (UserEntity) user.toEntity();
		response = new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ApiOperation(value = "Save the user provided", notes = "Save the user provided")
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity entity) {
		ResponseEntity<UserEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();

		validateEmailExists(entity.getEmail(), responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<UserEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		validateNicknameExists(entity.getNickname(), responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<UserEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		User user = (User) entity.toModel();
		entity = (UserEntity) userService.save(user).toEntity();

		response = new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
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

	/**
	 * Verify if the email is used
	 * 
	 * @param email
	 * @param headers
	 */
	private User validateEmailNotExists(String email, HttpHeaders headers) {
		User user = userService.findByEmail(email);

		if (user == null) {
			EventsErrorCode managedError = EventsErrorCode.USER_NOT_FOUND;
			log.error(managedError);
			headers.add("USER_NOT_FOUND", managedError.toString());
		}
		return user;
	}

	/**
	 * Verify if the nickname is used
	 * 
	 * @param nickname
	 * @param headers
	 */
	private User validateNicknameNotExists(String nickname, HttpHeaders headers) {
		User user = userService.findByNickname(nickname);

		if (user == null) {
			EventsErrorCode managedError = EventsErrorCode.USER_NOT_FOUND;
			log.error(managedError);
			headers.add("USER_NOT_FOUND", managedError.toString());
		}
		return user;
	}

}