package com.beesion.ms.test.resource;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/hello-world")
public class TestResource {

    private String procesarMensaje(String mensaje) {
        return Optional.ofNullable(mensaje).map(n -> "> " + n).orElse("No se que decir");
    }

    @GET
    public String helloWord() {
        return "Hello word!";
    }

    @GET
    @Path("/subHello")
    public String holaMundo() {
        return "Hola mundo!";
    }

    @POST
    @Path("/saludar")
    public String saludar(@QueryParam("mensaje") String mensaje) {
        return procesarMensaje(mensaje);
    }

    @PUT
    @Path("/modificar")
    public String modificar(@QueryParam("mensaje") String mensaje) {
        return procesarMensaje(mensaje);
    }
}