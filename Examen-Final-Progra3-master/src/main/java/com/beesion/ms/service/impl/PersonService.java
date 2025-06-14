package com.beesion.ms.service.impl;

import com.beesion.ms.domain.Person;
import com.beesion.ms.repository.PersonRepo;
import com.beesion.ms.service.IPersonService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;  // Importar la anotación

import java.util.List;

@ApplicationScoped
public class PersonService implements IPersonService {

	@Inject
	PersonRepo personRepo;

	@Override
	@Transactional  // <-- Aquí la agregamos para que haya transacción activa al persistir
	public void save(Person person) {
		personRepo.persist(person);
	}

	@Override
	public List<Person> findAll() {
		return personRepo.listAll();
	}
}
