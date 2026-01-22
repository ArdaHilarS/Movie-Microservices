package io.javabrains.movie_catalong_service.resources;

import io.javabrains.movie_catalong_service.models.CatalogItem;
import io.javabrains.movie_catalong_service.models.Movie;
import io.javabrains.movie_catalong_service.models.UserRating;
import io.javabrains.movie_catalong_service.models.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${movie.info.service.url}")
    private String movieInfoUrl;

    @Value("${rating.data.service.url}")
    private String ratingDataUrl;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating userRating = restTemplate.getForObject(
                ratingDataUrl + userId,
                UserRating.class
        );

        if (userRating == null || userRating.getUserRating() == null) {
            return Collections.emptyList();
        }

        return userRating.getUserRating()
                .stream()
                .map(this::buildCatalogItem)
                .collect(Collectors.toList());
    }

    private CatalogItem buildCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject(
                movieInfoUrl + rating.getMovieId(),
                Movie.class
        );

        if (movie == null) {
            return new CatalogItem("Movie not found", "No description", rating.getRating());
        }

        return new CatalogItem(
                movie.getName(),
                "Description here",
                rating.getRating()
        );
    }
}
