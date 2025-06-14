package com.beesion.ms.repository;

import com.beesion.ms.domain.Address;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {

    public List<Address> findByPersonId(Long personId) {
        return list("person.id", personId);
    }

}
