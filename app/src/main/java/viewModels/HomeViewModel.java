package viewModels;

import java.util.ArrayList;
import java.util.List;

import viewModels.movie.MovieCollection;
import viewModels.movie.NowPlayingCollection;
import viewModels.movie.PopularCollection;
import viewModels.movie.TopRatedCollection;
import viewModels.movie.UpcomingCollection;
import framework.viewModelBase.ViewModelBase;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class HomeViewModel extends ViewModelBase {
    private List<MovieCollection> movieCollections;

    @Override
    public void initialize() {
        super.initialize();
        isBusy.set(true);
        isBusy.set(false);
    }

    public List<MovieCollection> getMovieCollections() {
        if (movieCollections == null) {
            movieCollections = new ArrayList<>();
            movieCollections.add(new NowPlayingCollection());
            movieCollections.add(new UpcomingCollection());
            movieCollections.add(new PopularCollection());
            movieCollections.add(new TopRatedCollection());
        }
        return movieCollections;
    }
}
