package com.beesion.ms.mapper;

import com.beesion.ms.dto.AddressDto;
import com.beesion.ms.domain.Address;
import com.beesion.ms.domain.Person;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressMapper {

    public Address toEntity(AddressDto dto, Person person) {
        return Address.builder()
                .id(dto.getId())
                .street(dto.getStreet())
                .city(dto.getCity())
                .country(dto.getCountry())
                .person(person)  // Asignamos la entidad de la persona, no solo su ID
                .build();
    }

    public AddressDto toDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setCountry(address.getCountry());
        dto.setPersonId(address.getPerson().getId());
        return dto;
    }


    // Esta clase está dedicada únicamente al mapeo
}
