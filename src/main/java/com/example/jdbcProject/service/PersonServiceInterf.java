package com.example.jdbcProject.service;

import java.sql.SQLException;
import java.util.List;

import com.example.jdbcProject.dtos.CreatePersonDto;
import com.example.jdbcProject.model.Person;

public interface PersonServiceInterf {

void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPersonById(int id);
	
	Person deletePerson(int id);
	
	List<Person> getAllPersons() throws SQLException;	
}
