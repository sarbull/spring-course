package com.thalesgroup.trivia.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.thalesgroup.trivia.bean.Person;

@Repository("map")
public class PersonMapDAO implements DAO<Person> {

	private static Map<Integer, Person> map = new HashMap<>(); // di
	private static int sequence;

	public PersonMapDAO() {
		System.out.println("PersonMapDAO constructor");
	}

	@Override
	public void create(Person t) {

		System.out.println("Map.create");

		t.setId(sequence++);
		map.put(t.getId(), t);
	}

	@Override
	public void update(Person t) {
		map.put(t.getId(), t);
	}

	@Override
	public void delete(Integer id) {
		map.remove(get(id));
	}

	@Override
	public Person get(Integer id) {
		return map.get(id);
	}

	@Override
	public Person[] getAll() {
		return map.values().toArray(new Person[map.size()]);
	}

}
