package com.beesion.ms.repository.impl;

import com.beesion.ms.domain.Person;

import java.util.List;

public interface IPersonRepo {
	void save(Person per);
	List<Person> findAll();
}