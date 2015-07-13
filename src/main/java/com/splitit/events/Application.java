/*
 * *******************************************************************************
 *   Copyright 2015 Mercury Solutions and its affiliates.
 * *******************************************************************************
 */
package com.splitit.events;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * Main Spring boot configuration file. Starts up a Spring boot application.
 */
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@Import({ RepositoryRestMvcConfiguration.class })
@ComponentScan
//@EnableSwagger
public class Application {

	private final static Log log = LogFactory.getLog(Application.class);

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication app = new SpringApplication(Application.class);        
        app.addListeners(new ApplicationListener<ApplicationEnvironmentPreparedEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
            	MDC.put("appName", event.getEnvironment().getProperty("project.name"));
            	MDC.put("requestId", "N/A");
            	try {
					MDC.put("hostName",InetAddress.getLocalHost().getHostName());
				} catch (IllegalArgumentException | UnknownHostException e) {
					log.info(e);
				} 
            }
        });
        ApplicationContext ctx = app.run(args);
		log.info("-----------------------------------------------------------------");
		log.info("Active profiles:");
		Arrays.asList(ctx.getEnvironment().getActiveProfiles()).forEach(log::info);
		log.info("-----------------------------------------------------------------");
	}
}