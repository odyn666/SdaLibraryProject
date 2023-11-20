package pl.khas.SdaLibraryProject.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Alley {
    private long capacity; // w ksiazkach
    private String name;

    public Alley(String name) {
        this.capacity = 100;
        this.name = name;
    }
}
