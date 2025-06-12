package com.beesion.ms.test.repository.impl;

import com.beesion.ms.model.Person;

import java.util.List;

public interface IPersonRepo {
	void save(Person per);
	List<Person> findAll();
}