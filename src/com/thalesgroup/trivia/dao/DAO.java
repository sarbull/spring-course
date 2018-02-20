package com.thalesgroup.trivia.dao;

public interface DAO<T> {

	public void create(T t);

	public void update(T t);

	public void delete(final Integer id);

	public T get(final Integer id);

	public T[] getAll();

}
