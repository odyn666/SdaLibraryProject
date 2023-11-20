package pl.khas.SdaLibraryProject.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.khas.SdaLibraryProject.model.Person;
import pl.khas.SdaLibraryProject.repositories.PersonRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person")
 class PersonController {
    private final PersonRepository personRepository;
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    ResponseEntity<Person>createPerson(@RequestBody @Valid Person toCreate)
    {
        Person result = personRepository.save(toCreate);
        ResponseEntity<Person> created = ResponseEntity.created(URI.create("/" + result.getId())).body(result);
        logger.info("created new object " + result.toString());
        return created;
    }

    @GetMapping(params = {"!sort"})
    ResponseEntity<List<Person>> readAllTasks() {
        logger.warn("Exposing all the Persons!");
        return ResponseEntity.ok(personRepository.findAll());
    }


    @GetMapping("/{id}")
    ResponseEntity<Person> readTask(@PathVariable int id) {
        return personRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Person toUpdate) {
        if (!personRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        personRepository.findById(id)
                .ifPresent(person -> {
                    person.updateFrom(toUpdate);
                    personRepository.save(person);
                });
        return ResponseEntity.noContent().build();
    }


}
