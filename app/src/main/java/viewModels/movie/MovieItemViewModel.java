package viewModels.movie;

import api.TmdbService;
import info.movito.themoviedbapi.model.MovieDb;
import viewModels.ItemViewModel;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class MovieItemViewModel extends ItemViewModel {
    public MovieItemViewModel(MovieDb movie) {
        setTitle(movie.getTitle());
        setPosterImageUri(TmdbService.BasePosterImage + movie.getPosterPath());
        setBackdropImageUri(TmdbService.BaseBackdropImage + movie.getBackdropPath());
    }
}
