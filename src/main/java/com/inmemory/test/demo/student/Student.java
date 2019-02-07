package com.inmemory.test.demo.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String gender;

    public Student() {
	super();
    }

    public Student(Long id, String name, String address, String gender) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.gender = gender;
    }

    public Student(String name, String address, String gender) {
	super();
	this.name = name;
	this.address = address;
	this.gender = gender;
    }
}
