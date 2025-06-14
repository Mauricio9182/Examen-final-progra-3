package com.beesion.ms.service;

import com.beesion.ms.dto.AddressDto;
import java.util.List;

public interface AddressService {

    AddressDto createAddress(AddressDto dto);

    List<AddressDto> getAddressesByPersonId(Long personId);

    List<AddressDto> getAllAddresses();  // Método agregado para obtener todas las direcciones

}
