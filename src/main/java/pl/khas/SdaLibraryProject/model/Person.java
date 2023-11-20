package pl.khas.SdaLibraryProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    private int id;
    private String name;
    private String lastName;
    private String pesel;
    private int age;
    private boolean didRent;

    public void updateFrom(Person source) {
        this.name = source.name;
        this.lastName = source.lastName;
        this.pesel = source.pesel;
        this.age = source.age;
        this.didRent = source.didRent;
    }
}
