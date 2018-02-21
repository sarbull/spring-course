package com.thalesgroup.trivia.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.thalesgroup.trivia.bean.Answer;

@Repository("answers")
public class AnswerMapDAO implements DAO<Answer> {

	private static Map<Integer, Answer> map = new HashMap<>();
	private static int sequence;

	public AnswerMapDAO() {
		System.out.println("AnswerMapDAO constructor");
	}

	@Override
	public void create(Answer t) {
		System.out.println("Answer.create");

		t.setId(sequence++);
		map.put(t.getId(), t);
	}

	@Override
	public void update(Answer t) {
		map.put(t.getId(), t);
	}

	@Override
	public void delete(Integer id) {
		map.remove(get(id));
	}

	@Override
	public Answer get(Integer id) {
		return map.get(id);
	}

	@Override
	public Answer[] getAll() {
		return map.values().toArray(new Answer[map.size()]);
	}

}
