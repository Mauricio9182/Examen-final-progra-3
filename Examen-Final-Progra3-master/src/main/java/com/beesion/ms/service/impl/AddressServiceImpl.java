package com.beesion.ms.service.impl;

import com.beesion.ms.dto.AddressDto;
import com.beesion.ms.mapper.AddressMapper;
import com.beesion.ms.domain.Address;
import com.beesion.ms.domain.Person;
import com.beesion.ms.repository.AddressRepository;
import com.beesion.ms.repository.PersonRepo;
import com.beesion.ms.service.AddressService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AddressServiceImpl implements AddressService {

    @Inject
    AddressRepository addressRepository;

    @Inject
    PersonRepo personRepo;

    @Inject
    AddressMapper addressMapper;

    @Override
    @Transactional
    public AddressDto createAddress(AddressDto dto) {
        Person person = personRepo.findById(dto.getPersonId());
        if (person == null) {
            throw new IllegalArgumentException("Persona no encontrada con ID: " + dto.getPersonId());
        }

        Address address = addressMapper.toEntity(dto, person);
        addressRepository.persist(address);

        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressDto> getAddressesByPersonId(Long personId) {
        List<Address> addresses = addressRepository.findByPersonId(personId);
        return addresses.stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressRepository.listAll();
        return addresses.stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }
}
