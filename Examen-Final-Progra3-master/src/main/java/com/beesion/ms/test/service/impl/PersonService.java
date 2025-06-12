package com.beesion.ms.test.service.impl;

import com.beesion.ms.model.Person;
import com.beesion.ms.test.repository.impl.IPersonRepo;
import com.beesion.ms.test.service.IPersonService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PersonService implements IPersonService {

	@Inject
	private IPersonRepo personRepo;

	@Override
	public void save(Person per) {
		personRepo.save(per);
	}
}