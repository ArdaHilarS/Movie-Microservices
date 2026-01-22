package io.javabrains.movie_catalong_service.models;

import java.util.List;

public class UserRating {
    private List<Rating> userRating;

    public UserRating() {}

    public UserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
