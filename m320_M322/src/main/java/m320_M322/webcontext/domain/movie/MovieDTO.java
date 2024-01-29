package m320_M322.webcontext.domain.movie;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import m320_M322.config.generics.ExtendedDTO;

import java.time.LocalDate;

@Getter
@Setter
public class MovieDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    protected String name;

    @ManyToMany
    protected String genre;

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
