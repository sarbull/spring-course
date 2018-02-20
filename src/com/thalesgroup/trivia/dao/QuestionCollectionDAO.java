package com.thalesgroup.trivia.dao;

import java.util.Collection;

import com.thalesgroup.trivia.bean.Question;

public class QuestionCollectionDAO implements DAO<Question> {

	private final Collection<Question> collection; // di
	private int sequence;

	public QuestionCollectionDAO(Collection<Question> collection, int sequence) {
		System.out.println("PersonListDAO constructor");
		this.collection = collection;
		this.sequence = sequence;
	}

	@Override
	public void create(Question t) {

		t.setId(++sequence);
		collection.add(t);
	}

	@Override
	public void update(Question t) {
		delete(t.getId());
		create(t);
	}

	@Override
	public void delete(Integer id) {
		collection.remove(get(id));
	}

	@Override
	public Question get(Integer id) {
		for (Question p : collection) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public Question[] getAll() {
		return collection.toArray(new Question[collection.size()]);
	}

}
