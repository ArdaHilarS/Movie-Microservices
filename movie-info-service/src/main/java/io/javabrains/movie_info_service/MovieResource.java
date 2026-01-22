package io.javabrains.movie_info_service.resources;

import io.javabrains.movie_info_service.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieResource {

    @GetMapping("/movies/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {
        return new Movie(movieId, "Nemo");
    }
}
