package api;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * Created by Thomas.Jacob on 7/26/2016.
 */
public class TmdbService implements ContentService {

    private static final String API_KEY = "d0e16fe7e7812e34e97841781fd5c04e";
    private static ContentService instance;
    private final TmdbApi tmdbApi;

    public TmdbService() {
        tmdbApi = new TmdbApi(API_KEY);
    }

    public static ContentService getInstance() {
        if (instance == null) {
            instance = new TmdbService();
        }
        return instance;
    }

    @Override
    public MovieResultsPage getNowPlayingMovies(int page) {
        TmdbMovies tmdbMovies = tmdbApi.getMovies();
        return tmdbMovies.getNowPlayingMovies("en", 0);
    }
}
