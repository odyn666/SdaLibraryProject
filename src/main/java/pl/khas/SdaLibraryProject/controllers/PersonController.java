package pl.khas.SdaLibraryProject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.khas.SdaLibraryProject.model.Person;
import pl.khas.SdaLibraryProject.repositories.PersonRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@Log4j2
 class PersonController {
    private final PersonRepository personRepository;
    @PostMapping
    ResponseEntity<Person>createPerson(@RequestBody Person toCreate)
    {
        Person result = personRepository.save(toCreate);
        ResponseEntity<Person> created = ResponseEntity.created(URI.create("/" + result.getId())).body(result);
        log.info("created new object " + result.toString());
        return created;
    }

    @GetMapping(params = {"!sort"})
    ResponseEntity<List<Person>> readAllTasks() {
        log.warn("Exposing all the Persons!");
        return ResponseEntity.ok(personRepository.findAll());
    }


    @GetMapping("/{id}")
    ResponseEntity<Person> readTask(@PathVariable int id) {
        return personRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody Person toUpdate) {
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
