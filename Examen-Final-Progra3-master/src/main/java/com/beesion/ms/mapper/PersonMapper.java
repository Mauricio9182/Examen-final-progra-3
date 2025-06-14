package com.beesion.ms.mapper;

import com.beesion.ms.domain.Person;
import com.beesion.ms.dto.PersonDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonMapper {

    public PersonDto toDto(Person entity) {
        if (entity == null) return null;

        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Person toEntity(PersonDto dto) {
        if (dto == null) return null;

        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
