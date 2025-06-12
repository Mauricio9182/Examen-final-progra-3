package com.beesion.ms.test.resource;

import com.beesion.ms.test.dto.PersonDto;
import com.beesion.ms.test.mapper.PersonMapper;
import com.beesion.ms.test.service.IPersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/Person")
public class PersonaResource {

	@Inject
	private IPersonService personService;

	@Inject
	private PersonMapper personMapper;

	@POST
	public Response save(PersonDto per) {
		personService.save(personMapper.toEntity(per));
		return Response.ok("Elemento guardado").build();
	}
}