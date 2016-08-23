package viewModels.movie;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.model.MovieDb;
import framework.viewModelBase.CollectionViewModel;

/**
 * Created by thomas on 7/31/2016.
 */
public abstract class MovieCollection extends CollectionViewModel<MovieItemViewModel, MovieDb> {
    private boolean isLoaded;

    public MovieCollection(String title) {
        super(title);
    }

    @Override
    public void initialize() {
        super.initialize();
        if (!isLoaded && !isBusy.get()) {
            isBusy.set(true);
            loadMovies();
            isBusy.set(false);
        }
    }

    private void loadMovies() {
        createItemList(getList());
    }

    private void createItemList(List<MovieDb> movieItems) {
        List<MovieItemViewModel> movies = new ArrayList<>();
        for (MovieDb movie : movieItems) {
            MovieItemViewModel movieItemViewModel = new MovieItemViewModel(movie);
            movies.add(movieItemViewModel);
        }
        setItems(movies);
        isLoaded = true;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
