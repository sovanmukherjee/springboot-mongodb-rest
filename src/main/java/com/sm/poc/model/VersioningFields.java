package com.sm.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersioningFields {
    private String createdBy;
    @Indexed(name = "crTime", unique = true, expireAfter = "1d")
    private LocalDateTime crTime;
    private LocalDateTime mdTime;
    private String updatedBy;
}
