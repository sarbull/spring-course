package com.thalesgroup.trivia.service;

import java.io.PrintStream;
import java.util.Arrays;

import com.thalesgroup.trivia.bean.Person;
import com.thalesgroup.trivia.dao.DAO;

public class PersonService {

	private DAO<Person> dao;
	private PrintStream ps = System.out;

	public PersonService(DAO<Person> dao, PrintStream ps) {
		super();
		this.dao = dao;
		this.ps = ps;
	}

	public void createPersons(int counter) {
		// create 3 users
		for (int i = 1; i <= counter; i++) {
			dao.create(new Person("Name " + i, "nume" + i + "@email.com", "0723 123456 - " + i, "The Company"));
		}
	}

	public void printAll() {
		ps.println(Arrays.asList(dao.getAll()));

	}

}
