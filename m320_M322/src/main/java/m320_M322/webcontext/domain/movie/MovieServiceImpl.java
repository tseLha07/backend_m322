package m320_M322.webcontext.domain.movie;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import m320_M322.config.generics.ExtendedJpaRepository;
import m320_M322.config.generics.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Log4j2
@Service
public class MovieServiceImpl extends ExtendedServiceImpl<Movie> implements MovieService{

    private final MovieRepository repositoryMovie;

    @Autowired
    public MovieServiceImpl(MovieRepository repository) {
        super(repository);
        this.repositoryMovie = repository;
    }

    @Override
    public Movie save(Movie entity) {
        log.trace("trying to save a movie.");
        return repositoryMovie.save(entity);
    }

    @Override
    public Movie updateById(String id, Movie entity) {
        entity.setId(id);
        log.trace("trying to update the movie.");
        Movie movie = repositoryMovie.save(entity);
        log.debug("Entity has been successfully updated.");
        return movie;
    }

    @Override
    public void deleteById(String id) {
        if(!repositoryMovie.existsById(id)) {
            throw new NoSuchElementException(String.format("Movie with ID '%s' not found", id));
        }
        repositoryMovie.deleteById(id);
        log.debug("Successfully deleted movie");
    }

}
