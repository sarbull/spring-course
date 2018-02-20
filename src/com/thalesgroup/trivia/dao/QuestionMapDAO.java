package com.thalesgroup.trivia.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.thalesgroup.trivia.bean.Question;

@Repository("map")
public class QuestionMapDAO implements DAO<Question> {

	private static Map<Integer, Question> map = new HashMap<>(); // di
	private static int sequence;

	public QuestionMapDAO() {
		System.out.println("QuestionMapDAO constructor");
	}

	@Override
	public void create(Question t) {

		//System.out.println("Map.create");

		t.setId(sequence++);
		map.put(t.getId(), t);
	}

	@Override
	public void update(Question t) {
		map.put(t.getId(), t);
	}

	@Override
	public void delete(Integer id) {
		map.remove(get(id));
	}

	@Override
	public Question get(Integer id) {
		return map.get(id);
	}

	@Override
	public Question[] getAll() {
		return map.values().toArray(new Question[map.size()]);
	}

}
