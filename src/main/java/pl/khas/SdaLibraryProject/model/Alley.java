package pl.khas.SdaLibraryProject.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Alley {
    private int capacity; // w ksiazkach
    @NotBlank
    @NotNull
    private String name;

    public Alley(String name) {
        this.capacity = 100;
        this.name = name;
    }
}
