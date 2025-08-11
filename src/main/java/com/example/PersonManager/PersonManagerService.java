package com.example.PersonManager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManagerService {

    private final PersonRepository repository;

    public PersonManagerService(PersonRepository repository) {
        this.repository = repository;
    }

    public void createPerson(PersonDto personDto) {
        Person details = new Person();
        details.setFirstName(personDto.getFirstName());
        details.setLastName(personDto.getLastName());
        details.setEmail(personDto.getEmail());
        repository.save(details);
    }

    public List<PersonDto> getPersonList() {
        List<Person> personList = repository.findAll();
        return personList.stream()
                .map(person -> {
                    PersonDto personDto = new PersonDto();
                    personDto.setId(person.getId());
                    personDto.setFirstName(person.getFirstName());
                    personDto.setLastName(person.getLastName());
                    personDto.setEmail(person.getEmail());
                    return personDto;
                }).toList();
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}
