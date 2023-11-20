package pl.khas.SdaLibraryProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private Author authors;
    private Set<Genre> genres;
}
