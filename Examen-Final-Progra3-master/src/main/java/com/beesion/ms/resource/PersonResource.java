package com.beesion.ms.resource;

import com.beesion.ms.dto.PersonDto;
import com.beesion.ms.mapper.PersonMapper;
import com.beesion.ms.service.IPersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

	@Inject
	private IPersonService personService;

	@Inject
	private PersonMapper personMapper;

	@POST
	public Response save(PersonDto perDto) {
		personService.save(personMapper.toEntity(perDto));
		return Response.status(Response.Status.CREATED).entity(perDto).build();
	}

	@GET
	public Response getAll() {
		List<PersonDto> dtos = personService.findAll()
				.stream()
				.map(personMapper::toDto)
				.collect(Collectors.toList());
		return Response.ok(dtos).build();
	}

}
