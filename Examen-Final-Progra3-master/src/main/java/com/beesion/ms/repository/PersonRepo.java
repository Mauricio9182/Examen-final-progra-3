package com.beesion.ms.repository;

import com.beesion.ms.domain.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepo implements PanacheRepository<Person> {

	// Ya puedes usar métodos como:
	// - findById(Long id)
	// - listAll()
	// - persist(Person person)
	// - deleteById(Long id)
	// sin necesidad de EntityManager ni lógica personalizada

}
