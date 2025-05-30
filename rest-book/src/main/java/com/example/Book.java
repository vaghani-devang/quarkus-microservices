package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "This is a Book")
public class Book {

    @JsonProperty("isbn_13")
    @Schema(required = true )
    public String isbn13;

    @Schema(required = true)
    public String title;

    public String author;

    @JsonProperty("year_of_publication")
    public int yearOfPublication;

    public String genre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @JsonProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;

    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre='" + genre + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
