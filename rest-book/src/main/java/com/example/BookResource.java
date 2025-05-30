package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.Instant;

@Path("/api/books")
@Tag(name = "Book REST Endpoint")
public class BookResource {

    @Inject
    @RestClient
    NumberProxy proxy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
        summary = "Creates a Book",
        description = "Created a Book with ISBN number"
    )
    @Retry(maxRetries = 3, maxDuration = 3000)
    @Fallback(fallbackMethod = "FallbackOncreatingBook")
    public Response createBook(@FormParam("title") String title, @FormParam("author") String author, @FormParam("year") int yearOfPublication, @FormParam("genre") String genre) {
        Book book = new Book();
        book.isbn13 = proxy.generateIsbnNumbers().isbn13;
        book.title = title;
        book.author = author;
        book.yearOfPublication = yearOfPublication;
        book.genre = genre;
        book.creationDate = Instant.now();

        return Response.ok(book).build();
    }


    public Response FallbackOncreatingBook(String title, String author, int yearOfPublication, String genre) {
        Book book = new Book();
        book.isbn13 = "will add later";
        book.title = title;
        book.author = author;
        book.yearOfPublication = yearOfPublication;
        book.genre = genre;
        book.creationDate = Instant.now();

        // we can save book on local
        return Response.ok(book).build();
    }
}
