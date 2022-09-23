package com.sm.poc.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contact {
    private String emailId;
    private String mobile;
}
