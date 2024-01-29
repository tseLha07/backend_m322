package m320_M322.webcontext.domain.movie;

import m320_M322.webcontext.domain.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    private final MovieMapper movieMapper;

    @Autowired
    public MovieController (MovieService movieService, MovieMapper movieMapper){
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDTOs(movieService.findAll()));
    }

    @GetMapping({"/{movieId}"})
    public ResponseEntity<MovieDTO> getById(@PathVariable("movieId") UUID movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDTO(movieService.findById(movieId)));
    }

    @PostMapping("/")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieMapper.toDTO(movieService.save(movieMapper.fromDTO(movie))));
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDTO> editMovie(@RequestBody MovieDTO movie, @PathVariable("movieiD") UUID movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(movieMapper.toDTO(
                movieService.updateById(movieId, movieMapper.fromDTO(movie))));
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<MovieDTO> deleteMovie(
            @PathVariable("movieId") UUID movieId) {
        movieService.deleteById(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
