package com.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Number MicroService",
                    description = "This Microservice generates ISBN numbers for books",
                    version = "1.0"),
        tags = {
                @Tag(name = "api", description = "Public API for generating book numbers")
        }
)
public class NumberMicroService extends Application {
}
