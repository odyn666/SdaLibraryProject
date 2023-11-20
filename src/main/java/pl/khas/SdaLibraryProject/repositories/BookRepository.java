package pl.khas.SdaLibraryProject.repositories;

import org.springframework.stereotype.Repository;
import pl.khas.SdaLibraryProject.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository {
    List<Book> findAll();
    List<Book> findByTitle(String title);
    List<Book> findByAuthors(String authors);
    List<Book> findByGenres(String genres);
    Optional<Book> findById(int id);
    Book save(Book entity);
    boolean isRented(Book entity);
    boolean existsById(Integer id);

}
