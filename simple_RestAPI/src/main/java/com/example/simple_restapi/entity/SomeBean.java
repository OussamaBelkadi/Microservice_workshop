package com.example.simple_restapi.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String value1;
    private String value2;
    private String value3;

}
