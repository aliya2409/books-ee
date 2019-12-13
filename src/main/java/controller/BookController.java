package controller;

import ejb.BookServiceEJB;
import entity.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/book")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class BookController {

    @Inject
    BookServiceEJB bookService;
    @Context
    private UriInfo uriInfo;

    @POST
    public Response createBook(Book book) {
        bookService.createBook(book);
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
        return Response.created(bookUri).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") Long id) {
        Book book = bookService.findById(id);
        return Response.ok(book).build();
    }

    @GET
    public Response getBooks() {
        List<Book> books = bookService.findBooks();
        return Response.ok(books).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        bookService.deleteBook(bookService.findById(id));
        return Response.noContent().build();
    }
}
