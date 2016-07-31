package api;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * Created by Thomas.Jacob on 7/26/2016.
 */
public class TmdbService implements ContentService {

    private static final String API_KEY = "d0e16fe7e7812e34e97841781fd5c04e";
    private static final String API_LANG = "en";
    private static ContentService instance;
    private final TmdbApi tmdbApi;
    private TmdbMovies tmdbMovies;

    public TmdbService() {
        tmdbApi = new TmdbApi(API_KEY);
        tmdbMovies = tmdbApi.getMovies();
    }

    public static ContentService getInstance() {
        if (instance == null) {
            instance = new TmdbService();
        }
        return instance;
    }

    @Override
    public MovieResultsPage getNowPlayingMovies(int page) {
        return tmdbMovies.getNowPlayingMovies(API_LANG, 0);
    }

    @Override
    public MovieResultsPage getUpcomingMovies(int page) {
        return tmdbMovies.getUpcoming(API_LANG, 0);
    }

    @Override
    public MovieResultsPage getPopularMovies(int page) {
        return tmdbMovies.getPopularMovies(API_LANG, 0);
    }

    @Override
    public MovieResultsPage getTopRatedMovies(int page) {
        return tmdbMovies.getTopRatedMovies("en", 0);
    }
}
