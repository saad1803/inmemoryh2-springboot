package com.inmemory.test.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.inmemory.test.demo.student.Student;
import com.inmemory.test.demo.student.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InMemoryService {

    @Autowired
    StudentRepository studentRepo;

    public List<Student> getStudentList() {

	if (log.isDebugEnabled()) {
	    log.debug("Entering Student");
	}

	List<Student> studentList = studentRepo.findAll();

	return studentList;
    }

    @Cacheable(value = "students", key = "#id")
    public Student getStudent(Long id) {

	if (log.isDebugEnabled()) {
	    log.debug("Entering Student");
	}

	try {
	    System.out.println("Going to sleep for 5 sec");
	    Thread.sleep(1000 * 5);

	} catch (Exception e) {
	    log.error(e.getMessage());
	}
	Student student = studentRepo.findById(id);

	return student;
    }
}
