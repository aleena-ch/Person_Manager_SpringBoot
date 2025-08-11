package com.example.PersonManager;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web controller to handle HTTP requests related to persons.
 * Supports Thymeleaf UI pages to create, list, and delete persons.
 */
@RestController
@RequestMapping("/api/person")
public class PersonManagerController {

    private final PersonManagerService service;

    public PersonManagerController(PersonManagerService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDTO) {
        service.createPerson(personDTO);
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PersonDto>> getPersonDetails() {
        List<PersonDto> list = service.getPersonList();
        if (!list.isEmpty()) {
            return ResponseEntity.ok().body(list);
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePerson(@PathVariable Long id) {
        service.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
