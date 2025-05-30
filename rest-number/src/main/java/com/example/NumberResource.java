package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name = "Number REST Endpoint")
public class NumberResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Generate Book Numbers",
        description = "ISBN 13 and ISBN 10 Numbers"
    )
    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.isbn13 = "13-" + new Random().nextInt(100_000_000);
        isbnNumbers.isbn10 = "10-" + new Random().nextInt(100_000);
        isbnNumbers.generationDate = Instant.now();
        return isbnNumbers;
    }
}
