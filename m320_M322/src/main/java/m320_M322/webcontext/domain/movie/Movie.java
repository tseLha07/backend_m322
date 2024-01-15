package m320_M322.webcontext.domain.movie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import m320_M322.webcontext.domain.genre.Genre;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;

    @Getter
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @ManyToMany
    private Collection<Genre> genre;

    @NotNull
    @Column(name = "cast")
    private String cast;

    @NotNull
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull
    @Column(name = "summary")
    private String summary;

    @NotNull
    @Column(name = "image")
    private String imageURL;

    public Movie(String name, String cast, LocalDate releaseDate, String summary, String imageURL){
        this.name = name;
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

    public Movie setCast(String cast) {
        this.cast = cast;
        return this;
    }

    public Movie setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Movie setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Movie setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }
}
