package com.beesion.ms.service;

import com.beesion.ms.domain.Person;
import java.util.List;

public interface IPersonService {

	void save(Person per);

	List<Person> findAll();  // Agregado método para listar todas las personas
}
