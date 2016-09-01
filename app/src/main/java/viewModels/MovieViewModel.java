package viewModels;

import java.util.ArrayList;
import java.util.List;

import framework.viewModelBase.ViewModelBase;
import viewModels.movie.MovieCollection;
import viewModels.movie.PopularCollection;
import viewModels.movie.TopRatedCollection;
import viewModels.movie.UpcomingCollection;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class MovieViewModel extends ViewModelBase {

    private List<MovieCollection> movieCollections;

    @Override
    public void initialize() {
        super.initialize();
    }

    public List<MovieCollection> getMovieCollections() {
        if (movieCollections == null) {
            movieCollections = new ArrayList<>();
            movieCollections.add(new UpcomingCollection());
            movieCollections.add(new PopularCollection());
            movieCollections.add(new TopRatedCollection());
        }
        return movieCollections;
    }
}
