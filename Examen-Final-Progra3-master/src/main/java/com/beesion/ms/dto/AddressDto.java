package com.beesion.ms.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private String country;
    private Long personId;


    // Este DTO permite recibir y enviar direcciones sin usar directamente la entidad Address.
    // Incluye el ID de la persona para establecer la relación.
}
