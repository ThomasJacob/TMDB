package viewModels;

import android.databinding.ObservableBoolean;

import java.util.ArrayList;
import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class HomeViewModel extends ViewModelBase {
    public ObservableBoolean isBusy = new ObservableBoolean();
    private List<MovieViewModel> movieCollection;

    public void initialize() {
        isBusy.set(true);
        LoadNowPlayingMovies();
        isBusy.set(false);
    }

    private void LoadNowPlayingMovies() {
        List<MovieDb> movieItems = TmdbService.getInstance().getNowPlayingMovies(0).getResults();
        List<MovieViewModel> movies = new ArrayList<>();
        for (MovieDb movie : movieItems) {
            MovieViewModel movieViewModel = new MovieViewModel(movie);
            movies.add(movieViewModel);
        }
        setMovieCollection(movies);
    }


    public List<MovieViewModel> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(List<MovieViewModel> movieCollection) {
        this.movieCollection = movieCollection;
    }
}
