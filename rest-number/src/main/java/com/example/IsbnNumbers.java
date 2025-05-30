package com.example;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "ISBN Numbers for Books")
public class IsbnNumbers {

    @Schema(required = true)
    @JsonProperty("isbn_13")
    public String isbn13;

    @Schema(required = true)
    @JsonProperty("isbn_10")
    public String isbn10;

    @JsonIgnore
    public Instant generationDate;

    @Override
    public String toString() {
        return "IsbnNumbers{" +
                "isbn13='" + isbn13 + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", generationDate=" + generationDate +
                '}';
    }
}
