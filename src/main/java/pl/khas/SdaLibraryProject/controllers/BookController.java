package pl.khas.SdaLibraryProject.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.khas.SdaLibraryProject.model.Book;
import pl.khas.SdaLibraryProject.repositories.BookRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Log4j2
public class BookController {
    private final BookRepository bookRepository;

    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody Book toCreate) {
        Book result = bookRepository.save(toCreate);
        ResponseEntity<Book> created = ResponseEntity.created(URI.create("/" + result.getId())).body(result);
        log.info("created new object " + result.toString());
        return created;
    }

    @GetMapping(params = {"!sort"})
    ResponseEntity<List<Book>> readAllTasks() {
        log.warn("Exposing all Books!");
        return ResponseEntity.ok(bookRepository.findAll());
    }

    ResponseEntity<Book> readTask(@PathVariable int id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody Book toUpdate) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.findById(id)
                .ifPresent(book -> {
                    book.updateFrom(toUpdate);
                    bookRepository.save(book);
                });
        return ResponseEntity.noContent().build();
    }
}
