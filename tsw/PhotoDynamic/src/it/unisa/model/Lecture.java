package it.unisa.model;

public class Lecture {
	private int id;
	private String name;
	private String surname;
	
	public Lecture() {
		this.id = -1;
		this.name = "";
		this.surname = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
