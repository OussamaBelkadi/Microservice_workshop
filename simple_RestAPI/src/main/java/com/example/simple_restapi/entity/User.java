package com.example.simple_restapi.entity;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2 ,message = "the field should contain at last 2 character")
    private  String name;
    @Past(message = "the date should be before the date of today")
    private LocalDate birthDate;
}
