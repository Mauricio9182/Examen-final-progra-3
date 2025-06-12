package com.beesion.ms.test.repository;

import com.beesion.ms.model.Person;
import com.beesion.ms.test.repository.impl.IPersonRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonRepo implements IPersonRepo {

	@Inject
	EntityManager em;

	@Override
	@Transactional
	public void save(Person per) {
		em.persist(per);
	}

	@Override
	public List<Person> findAll() {
		return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	}
}