package com.aprendendoEnpoints.demo.resources;

import com.aprendendoEnpoints.demo.models.Person;
import com.aprendendoEnpoints.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        personRepository.save(person);
        return  new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>>getAll() {
        List<Person> persons;
        persons = personRepository.findAll();
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable Integer id) {
        Optional<Person> person;
        person = personRepository.findById(id);
        return  new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("getName")
    public ResponseEntity<Optional<Person>> getByName(@RequestParam("name") String name,@RequestParam("email") String email){
        Optional<Person> person;
        person = personRepository.findByNameAndEmail(name,email);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @GetMapping("dateAfter")
    public ResponseEntity<List<Person>> getByDateCadastroAfter(@RequestParam("date") LocalDate cadastro){
        List<Person> person;
        person = personRepository.findByCadastroAfter(cadastro);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @GetMapping("dateBetween")
    public ResponseEntity<List<Person>> getByDateBetween(@RequestParam("inicio") LocalDate inicio,@RequestParam("fim") LocalDate fim){
        List<Person> person;
        person = personRepository.findByCadastroBetween(inicio,fim);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }




}

