package com.example.PersonManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web controller to handle HTTP requests related to persons.
 * Supports Thymeleaf UI pages to create, list, and delete persons.
 */
@Controller
@RequestMapping("/persons")
public class PersonWebController {

    private final PersonManagerService service;

    public PersonWebController(PersonManagerService service) {
        this.service = service;
    }

    @PostMapping
    public String createPerson(@ModelAttribute("personDto") PersonDto personDto) {
        service.createPerson(personDto);
        return "redirect:/persons";
    }

    @GetMapping
    public String getPersonDetails(Model model) {
        List<PersonDto> persons = service.getPersonList();
        model.addAttribute("persons", persons);
        model.addAttribute("personDto", new PersonDto());
        return "persons";
    }

    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        service.deletePerson(id);
        return "redirect:/persons";
    }
}
