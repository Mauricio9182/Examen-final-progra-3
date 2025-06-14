package com.beesion.ms.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Person {

	@Id
	@SequenceGenerator(name = "PersonIdGenerator", sequenceName = "person_seq", allocationSize = 1)
	@GeneratedValue(generator = "PersonIdGenerator")
	private Long id;

	private String name;

	// Getters y setters normales
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
