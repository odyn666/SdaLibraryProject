package pl.khas.SdaLibraryProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String title;
    private String authors;
    private String genres;
    private int pages;
    private String alley;
    private boolean isRented;

    public void updateFrom(Book source) {
        this.title = source.title;
        this.authors = source.authors;
        this.genres = source.genres;
        this.pages = source.pages;
        this.isRented = source.isRented;
        this.alley = source.alley;
    }
}
