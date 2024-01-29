package m320_M322.webcontext.domain.movie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import m320_M322.config.generics.ExtendedEntity;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie extends ExtendedEntity {

    @Getter
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @Getter
    @NotNull
    @Column(name = "genre")
    private String genre;

    @Getter
    @NotNull
    @Column(name = "cast")
    private String cast;

    @Getter
    @NotNull
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Getter
    @NotNull
    @Column(name = "summary")
    private String summary;

    @Getter
    @NotNull
    @Column(name = "image")
    private String imageURL;

    public Movie(String name, String genre, String cast, LocalDate releaseDate, String summary, String imageURL){
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.cast = cast;
        this.summary = summary;
        this.imageURL = imageURL;
    }

    public Movie(){}

    public Movie setName(String name) {
        this.name = name;
        return this;
    }
}
