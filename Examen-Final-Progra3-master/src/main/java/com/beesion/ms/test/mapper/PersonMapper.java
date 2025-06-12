package com.beesion.ms.test.mapper;

import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.PersonDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonMapper {
    public Person toEntity(PersonDto dto) {
        Person person = new Person();
        person.setName(dto.getName());
        return person;
    }
}