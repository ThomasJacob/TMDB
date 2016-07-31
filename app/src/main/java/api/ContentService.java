package api;

import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * Created by Thomas.Jacob on 7/26/2016.
 */
public interface ContentService {
    MovieResultsPage getNowPlayingMovies(int page);
    MovieResultsPage getUpcomingMovies(int page);
    MovieResultsPage getPopularMovies(int page);
    MovieResultsPage getTopRatedMovies(int page);
}
