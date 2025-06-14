package com.beesion.ms.service.impl;

import com.beesion.ms.domain.Person;
import com.beesion.ms.repository.impl.IPersonRepo;
import com.beesion.ms.service.IPersonService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService implements IPersonService {

	@Inject
	private IPersonRepo personRepo;

	@Override
	public void save(Person per) {
		personRepo.save(per);
	}

	@Override
	public List<Person> findAll() {
		return personRepo.findAll();
	}
}
