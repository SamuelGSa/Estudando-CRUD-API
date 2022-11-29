package com.aprendendoEnpoints.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Person {

    @GeneratedValue
    @Id
    private  Integer id;

    private String name;
    private Integer age;
    private String email;

    LocalDate cadastro= LocalDate.now();

}
