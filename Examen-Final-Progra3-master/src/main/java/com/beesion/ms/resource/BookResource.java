package com.beesion.ms.resource;

import java.util.List;

import com.beesion.ms.domain.Book;
import com.beesion.ms.dto.BookDto;
import com.beesion.ms.mapper.BookMapper;
import com.beesion.ms.repository.BookRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/book")
public class BookResource {

	private static final Logger logger = LogManager.getLogger(BookResource.class);

	@Inject
	private BookRepository repo;

	@Inject
	private BookMapper bookMapper;

	@GET
	public List<Book> index() {
		return repo.listAll();
	}

	@POST
	public Response insert(BookDto b) {
		Book book = bookMapper.toEntity(b);
		repo.persist(book);
		return Response.ok("Se ha registrado").build();
	}

	@GET
	@Path("{id}")
	public Response getBook(@PathParam("id") Long id) {
		var book = repo.findById(id);
		if (book != null) {
			return Response.ok(book).build();
		} else {
			return Response.status(404).entity("No existe ese id").build();
		}
	}

	// ✅ NUEVO ENDPOINT USANDO /book/mayorAId/{id}
	@GET
	@Path("mayorAId/{id}")
	public Response getBooksByPageCountGreaterThan(@PathParam("id") Long id) {
		List<Book> books = repo.find("numPages > ?1", id).list();
		if (books == null || books.isEmpty()) {
			return Response.status(404).entity("No hay libros con más páginas que " + id).build();
		}
		return Response.ok(books).build();
	}
}
