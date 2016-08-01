package api;

import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * Created by Thomas.Jacob on 7/26/2016.
 */
public interface ITmdbService {
    //    Movie
    MovieResultsPage getNowPlayingMovies(int page);

    MovieResultsPage getUpcomingMovies(int page);

    MovieResultsPage getPopularMovies(int page);

    MovieResultsPage getTopRatedMovies(int page);

    //    TV
    TvResultsPage getAiringTodayTV(int page);

    TvResultsPage getOnTV(int page);

    TvResultsPage getPopularTV(int page);

    TvResultsPage getTopRatedTV(int page);
}
