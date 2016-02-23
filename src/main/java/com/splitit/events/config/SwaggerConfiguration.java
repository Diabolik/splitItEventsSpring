/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions.
 * *******************************************************************************
 */

package com.splitit.events.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
public class SwaggerConfiguration {

	private SpringSwaggerConfig springSwaggerConfig;
	
	@Value("${swagger.apiInfo.title}")
	protected String swaggerTitle;
	
	@Value("${swagger.apiInfo.description}")
	protected String swaggerDescription;
	
	@Value("${swagger.apiInfo.termsOfServiceUrl}")
	protected String swaggerTermsOfServiceUrl;
	
	@Value("${swagger.apiInfo.contact}")
	protected String swaggerContact;
	
	@Value("${swagger.apiInfo.license}")
	protected String swaggerLicense;
	
	@Value("${swagger.apiInfo.licenseUrl}")
	protected String swaggerLicenseUrl;
	
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	// Don't forget the @Bean annotation
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo())
				.includePatterns("/api.*");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(swaggerTitle, 
				swaggerDescription, swaggerTermsOfServiceUrl,
				swaggerContact, swaggerLicense, swaggerLicenseUrl);
		return apiInfo;
	}
	
}
