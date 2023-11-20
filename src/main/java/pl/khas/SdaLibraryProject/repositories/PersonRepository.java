package pl.khas.SdaLibraryProject.repositories;

import org.springframework.stereotype.Repository;

import pl.khas.SdaLibraryProject.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository {
    List<Person>findAll();
    List<Person>didRent(boolean didRent);
    Optional<Person> findById(Integer id);

    Person save(Person entity);
    boolean existsById(Integer id);
}
