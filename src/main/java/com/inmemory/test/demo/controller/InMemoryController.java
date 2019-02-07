package com.inmemory.test.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inmemory.test.demo.service.InMemoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@CrossOrigin()
@Slf4j
public class InMemoryController {

    @Autowired
    private InMemoryService inmemoryService;

    @RequestMapping(value = "/getStudentList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getStudentList() throws Exception {

	if (log.isDebugEnabled()) {
	    log.debug("In Student List");
	}

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("data", inmemoryService.getStudentList());
	map.put("success", true);

	return new ResponseEntity<Map<String, Object>>(map, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getStudentById(@RequestParam(name = "id") String id) throws Exception {

	if (log.isDebugEnabled()) {
	    log.debug("Retrieving Student By Id");
	}

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("data", inmemoryService.getStudent(Long.parseLong(id)));
	map.put("success", true);

	return new ResponseEntity<Map<String, Object>>(map, HttpStatus.ACCEPTED);

    }
}
