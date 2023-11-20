package pl.khas.SdaLibraryProject.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.khas.SdaLibraryProject.model.Person;
import pl.khas.SdaLibraryProject.repositories.PersonRepository;
@Repository
public interface sqlPersonRepository extends PersonRepository, JpaRepository<Person,Integer> {
    @Override
    @Query(nativeQuery = true,value = "select count(*)>0 from person where id =:id")
    boolean existsById(@Param("id") Integer id);
}
