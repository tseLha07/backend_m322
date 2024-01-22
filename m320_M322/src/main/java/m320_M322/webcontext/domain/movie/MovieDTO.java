package m320_M322.webcontext.domain.movie;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import m320_M322.webcontext.domain.genre.Genre;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Collection;

public class MovieDTO {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    protected String id;

    @Getter
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    protected String name;

    @ManyToMany
    protected Collection<Genre> genre;

    @NotNull
    @Column(name = "cast")
    protected String cast;

    @NotNull
    @Column(name = "release_date")
    protected LocalDate releaseDate;

    @NotNull
    @Column(name = "summary")
    protected String summary;

    @NotNull
    @Column(name = "image")
    protected String imageURL;



}
