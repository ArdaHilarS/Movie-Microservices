package io.javabrains.movie_ratings_service;

import io.javabrains.movie_ratings_service.model.Rating;
import io.javabrains.movie_ratings_service.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingResource {

    @GetMapping("/ratingsdata/users/{userId}")
    public UserRating getUserRatings(@PathVariable String userId) {

        List<Rating> ratings = List.of(
                new Rating("100", 4),
                new Rating("200", 5)
        );

        return new UserRating(ratings);
    }

    @GetMapping("/ratings/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 9);
    }
}
