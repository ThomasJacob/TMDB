package viewModels;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by thomas on 7/31/2016.
 */
public abstract class MovieCollection extends CollectionViewModel<MovieViewModel, MovieDb> {
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
        List<MovieViewModel> movies = new ArrayList<>();
        for (MovieDb movie : movieItems) {
            MovieViewModel movieViewModel = new MovieViewModel(movie);
            movies.add(movieViewModel);
        }
        setItems(movies);
        isLoaded = true;
    }

    public abstract List<MovieDb> getList();

    public boolean isLoaded() {
        return isLoaded;
    }
}
