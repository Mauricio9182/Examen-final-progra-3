package com.beesion.ms.resource;

import com.beesion.ms.dto.AddressDto;
import com.beesion.ms.service.AddressService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    AddressService addressService;

    @POST
    @Transactional
    public Response createAddress(AddressDto dto) {
        try {
            AddressDto created = addressService.createAddress(dto);
            return Response.status(Response.Status.CREATED).entity(created).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/person/{id}")
    public Response getAddressesByPersonId(@PathParam("id") Long personId) {
        List<AddressDto> addresses = addressService.getAddressesByPersonId(personId);
        return Response.ok(addresses).build();
    }

    @GET
    public Response getAllAddresses() {
        List<AddressDto> addresses = addressService.getAllAddresses();
        return Response.ok(addresses).build();
    }
}
