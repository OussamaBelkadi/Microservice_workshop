package com.example.simple_restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class User {
    private Integer id;
    private  String name;
    private LocalDate birthDate;
}
