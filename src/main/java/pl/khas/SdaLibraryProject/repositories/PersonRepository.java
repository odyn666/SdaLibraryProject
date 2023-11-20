package pl.khas.SdaLibraryProject.repositories;

import org.springframework.stereotype.Repository;

import pl.khas.SdaLibraryProject.model.Person;

import java.util.List;

@Repository
public interface PersonRepository {
    List<Person>findAll();
    List<Person>didRent(boolean didRent);
    Person save(Person entity);
    boolean existsById(Integer id);
}
