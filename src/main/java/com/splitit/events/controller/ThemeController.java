/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */
package com.splitit.events.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.splitit.events.domain.Theme;
import com.splitit.events.entity.ThemeEntity;
import com.splitit.events.exception.EventsErrorCode;
import com.splitit.events.services.ThemeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(description = "Theme Model API", value = "")
public class ThemeController {

	private final static Log log = LogFactory.getLog(ThemeController.class);

	@Autowired
	private ThemeService themeService;

	@RequestMapping(value = "/themes/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieve the Theme by Id", notes = "Retrieve the Theme by Id")
	public ResponseEntity<ThemeEntity> findById(@RequestParam("id") long id) {
		ResponseEntity<ThemeEntity> response = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		
		Theme theme = validateThemeNotExists(id, responseHeaders);
		if (!responseHeaders.isEmpty()) {
			return new ResponseEntity<ThemeEntity>(null, responseHeaders, HttpStatus.NOT_FOUND);
		}

		ThemeEntity entity = (ThemeEntity) theme.toEntity();
		response = new ResponseEntity<ThemeEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/themes", method = RequestMethod.GET)
	@ApiOperation(value = "Retrieve all the Themes", notes = "Retrieve all the Themes")
	public List<ThemeEntity> findAll() {
		ArrayList<ThemeEntity> result = new ArrayList<ThemeEntity>();
		List<Theme> themes = themeService.findAll();
		themes.forEach(x -> {
			ThemeEntity entity = (ThemeEntity) x.toEntity();
			result.add(entity);
		});
		return result;
	}
	
	@RequestMapping(value = "/themes", method = RequestMethod.POST)
	@ApiOperation(value = "Save the theme provided", notes = "Save the theme provided")
	public ResponseEntity<ThemeEntity> save(@RequestBody ThemeEntity entity) {
		ResponseEntity<ThemeEntity> response = null;
		
		Theme theme = (Theme) entity.toModel();
		entity = (ThemeEntity) themeService.save(theme).toEntity();

		response = new ResponseEntity<ThemeEntity>(entity, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Verify if the theme is not used.
	 * 
	 * @param theme
	 * @param headers
	 */
	private Theme validateThemeNotExists(long id, HttpHeaders headers) {
		Theme theme = null;
		
		if (!themeService.exists(id)) {
			EventsErrorCode managedError = EventsErrorCode.THEME_NOT_FOUND;
			log.error(managedError);
			headers.add("THEME_NOT_FOUND", managedError.toString());
		} else {
			theme = themeService.findById(id);
		}
		return theme;
	}
}