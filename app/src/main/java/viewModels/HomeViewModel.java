package viewModels;

import java.util.ArrayList;
import java.util.List;

import framework.viewModelBase.ViewModelBase;
import viewModels.movie.MovieCollection;
import viewModels.movie.NowPlayingCollection;
import viewModels.movie.PopularCollection;
import viewModels.movie.TopRatedCollection;
import viewModels.movie.UpcomingCollection;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class HomeViewModel extends ViewModelBase {
    private List<MovieCollection> movieCollections;
    private MovieViewModel movieViewModel;
    private TVViewModel tvViewModel;

    public HomeViewModel() {
        movieViewModel = new MovieViewModel();
        tvViewModel = new TVViewModel();
    }

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

    public TVViewModel getTvViewModel() {
        return tvViewModel;
    }

    public MovieViewModel getMovieViewModel() {
        return movieViewModel;
    }
}
