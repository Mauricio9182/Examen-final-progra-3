package com.beesion.ms.mapper;

import com.beesion.ms.domain.Address;
import com.beesion.ms.domain.Person;
import com.beesion.ms.dto.AddressDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressMapper {

    public Address toEntity(AddressDto dto, Person person) {
        if (dto == null || person == null) {
            return null;
        }
        return Address.builder()
                .id(dto.getId())
                .street(dto.getStreet())
                .city(dto.getCity())
                .country(dto.getCountry())
                .person(person)
                .build();
    }

    public AddressDto toDto(Address address) {
        if (address == null) return null;

        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setCountry(address.getCountry());
        if (address.getPerson() != null) {
            dto.setPersonId(address.getPerson().getId());
        }
        return dto;
    }
}
