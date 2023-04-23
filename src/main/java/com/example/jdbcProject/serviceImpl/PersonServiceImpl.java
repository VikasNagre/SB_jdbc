package com.example.jdbcProject.serviceImpl;

import java.sql.SQLException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import com.example.jdbcProject.*;
import com.example.jdbcProject.dtos.CreatePersonDto;
import com.example.jdbcProject.model.Person;
import com.example.jdbcProject.repository.PersonRepositoryInterf;
import com.example.jdbcProject.repositoryImpl.PersonnRepositoryImpl;

import com.example.jdbcProject.service.PersonServiceInterf;

@Service
public class PersonServiceImpl implements PersonServiceInterf {

	
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public void createPersonStatic(CreatePersonDto createPersonDto) {
		Person person = createPersonDto.to();
		
		if(person.getAge() == null)
			person.setAge(calculateAgeFromDOB(person.getDob()));
//		personRepositoryInterf.createPerson(person);
		personRepositoryInterf.createPersonStatic(person);
	}
	
	private Integer calculateAgeFromDOB(String dob) {
		if(dob == null) {
			return null;
		}
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();

	}

	@Override
	public Person getPersonById(int id) {
		return personRepositoryInterf.getPersonById(id);
	}

	@Override
	public Person deletePerson(int id) {
		Person person = personRepositoryInterf.getPersonById(id);
		
		if(person == null) {
			throw new BadPersonRequestException("Person With id = "+id+" Not Present");
		}
		boolean isDeleted =  personRepositoryInterf.deletePerson(id);
		if(isDeleted) {
			return person;
		}
		return null;
	}

	@Override
	public List<Person> getAllPersons() throws SQLException {
		return personRepositoryInterf.getAllPersons();
	}


}
