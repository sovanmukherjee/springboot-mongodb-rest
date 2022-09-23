package com.sm.poc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;
import java.util.List;

public class PageDecorator<T>  {
    private final Page<T> page;

    public PageDecorator(Page<T> page) {
        this.page = page;
    }

    @JsonProperty("data") // override property name in json
    public List<T> getContent() {
        return this.page.getContent();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public long getTotalElements() {
        return page.getTotalElements();
    }

    @JsonProperty("pageNumber")
    public long getNumber(){
        return page.getNumber();
    }
}
