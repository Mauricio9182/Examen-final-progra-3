package com.beesion.ms.mapper;

import com.beesion.ms.domain.Person;
import com.beesion.ms.dto.PersonDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonMapper {

    // Para convertir entidad a DTO (para GET, listar, etc.)
    public PersonDto toDto(Person entity) {
        if (entity == null) return null;

        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    // Para convertir DTO a entidad (para crear POST)
    public Person toEntity(PersonDto dto) {
        if (dto == null) return null;

        Person entity = new Person();

        entity.setName(dto.getName());
        return entity;
    }

    // Puedes agregar este método para actualizar una entidad existente con datos de DTO (PUT o PATCH)
    public void updateEntity(PersonDto dto, Person entity) {
        if (dto == null || entity == null) return;
        entity.setName(dto.getName());

    }
}
