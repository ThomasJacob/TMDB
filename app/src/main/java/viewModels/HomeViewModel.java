package viewModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class HomeViewModel extends ViewModelBase {
    //    private List<MovieViewModel> nowPlayingMovies;
//    private List<MovieViewModel> upcomingMovies;
    private List<MovieCollection> movieCollections;

    @Override
    public void initialize() {
        super.initialize();
        isBusy.set(true);
//        LoadNowPlayingMovies();
//        LoadUpcomingMovies();
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

//    private void LoadNowPlayingMovies() {
//        List<MovieDb> movieItems = TmdbService.getInstance().getNowPlayingMovies(0).getResults();
//        List<MovieViewModel> movies = new ArrayList<>();
//        for (MovieDb movie : movieItems) {
//            MovieViewModel movieViewModel = new MovieViewModel(movie);
//            movies.add(movieViewModel);
//        }
//        setNowPlayingMovies(movies);
//    }
//
//    private void LoadUpcomingMovies() {
//        List<MovieDb> movieItems = TmdbService.getInstance().getUpcomingMovies(0).getResults();
//        List<MovieViewModel> movies = new ArrayList<>();
//        for (MovieDb movie : movieItems) {
//            MovieViewModel movieViewModel = new MovieViewModel(movie);
//            movies.add(movieViewModel);
//        }
//        setUpcomingMovies(movies);
//    }
//
////    public List<MovieViewModel> getNowPlayingMovies() {
////        return nowPlayingMovies;
////    }
//
//    public void setNowPlayingMovies(List<MovieViewModel> nowPlayingMovies) {
////        this.nowPlayingMovies = nowPlayingMovies;
//    }

//    public List<MovieViewModel> getUpcomingMovies() {
//        return upcomingMovies;
//    }
//
//    public void setUpcomingMovies(List<MovieViewModel> upcomingMovies) {
//        this.upcomingMovies = upcomingMovies;
//    }
}
