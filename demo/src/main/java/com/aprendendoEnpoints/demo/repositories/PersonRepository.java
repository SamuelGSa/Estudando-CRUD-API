package com.aprendendoEnpoints.demo.repositories;

import com.aprendendoEnpoints.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonRepository  extends JpaRepository<Person, Integer> {

    Optional<Person> findByNameAndEmail(String name, String email);

    Optional<Person> findByEmail(String email);

    List<Person> findByCadastroAfter(LocalDate cadastro);

    List<Person> findByCadastroBetween(LocalDate inicio, LocalDate fim);


}
