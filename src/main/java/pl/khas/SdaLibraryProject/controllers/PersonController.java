package pl.khas.SdaLibraryProject.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.khas.SdaLibraryProject.model.Person;
import pl.khas.SdaLibraryProject.repositories.PersonRepository;

import java.net.URI;

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


}
