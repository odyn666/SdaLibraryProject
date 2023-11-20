package pl.khas.SdaLibraryProject.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.khas.SdaLibraryProject.model.Book;
import pl.khas.SdaLibraryProject.repositories.BookRepository;

@Repository
public interface sqlBookRepository extends BookRepository, JpaRepository<Book, Integer> {
    @Override
    @Query(nativeQuery = true,value = "select count(*)>0 from book where id =:id")
    boolean existsById(@Param("id") Integer id);
}
