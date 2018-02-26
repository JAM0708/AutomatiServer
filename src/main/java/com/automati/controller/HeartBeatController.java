package com.automati.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {
	
	private Logger logger = Logger.getLogger(HeartBeatController.class);
	
	@RequestMapping(path="/heartbeat", method = RequestMethod.GET)
	public ResponseEntity<String> getHeartBeat() {
		logger.info("Heart beat was reached");
		return new ResponseEntity<>("Heart beat was hit", HttpStatus.OK);
	}

}
