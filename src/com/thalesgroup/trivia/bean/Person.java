package com.thalesgroup.trivia.bean;

public class Person extends Entity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String phone;
	private String company;

	public Person() {
		super();
	}

	public Person(String name, String email, String phone, String company) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "\nPerson [name=" + name + ", email=" + email + ", phone=" + phone + ", company=" + company + ", getId()=" + getId() + "]";
	}

}
