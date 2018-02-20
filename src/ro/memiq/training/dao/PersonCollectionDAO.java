package ro.memiq.training.dao;

import java.util.Collection;

import ro.memiq.training.bean.Person;

public class PersonCollectionDAO implements DAO<Person> {

	private final Collection<Person> collection; // di
	private int sequence;

	public PersonCollectionDAO(Collection<Person> collection, int sequence) {
		System.out.println("PersonListDAO constructor");
		this.collection = collection;
		this.sequence = sequence;
	}

	@Override
	public void create(Person t) {

		t.setId(++sequence);
		collection.add(t);
	}

	@Override
	public void update(Person t) {
		delete(t.getId());
		create(t);
	}

	@Override
	public void delete(Integer id) {
		collection.remove(get(id));
	}

	@Override
	public Person get(Integer id) {
		for (Person p : collection) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public Person[] getAll() {
		return collection.toArray(new Person[collection.size()]);
	}

}
