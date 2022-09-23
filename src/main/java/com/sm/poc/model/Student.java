package com.sm.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.UUID;

@Getter @Setter @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "student")
@Slf4j
public class Student {
    @Id
    private UUID id;

    @Indexed(name = "rollNumber")
    private int rollNumber;

    @Indexed(name = "firstName")
    private String firstName;

    @Indexed(name = "lastName")
    private String lastName;

    private Contact contact;

    private String className;

    private List<Score> scores;

    private VersioningFields vsningFlds;

}
