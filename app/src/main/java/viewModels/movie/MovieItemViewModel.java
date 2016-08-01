package viewModels.movie;

import info.movito.themoviedbapi.model.MovieDb;
import viewModels.ItemViewModel;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class MovieItemViewModel extends ItemViewModel {
    public MovieItemViewModel(MovieDb movie) {
        setTitle(movie.getTitle());
        setImageUri("https://image.tmdb.org/t/p/w185" + movie.getPosterPath());
    }
}
