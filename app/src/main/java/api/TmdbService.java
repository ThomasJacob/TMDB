package api;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

/**
 * Created by Thomas.Jacob on 7/26/2016.
 */
public class TmdbService implements ITmdbService {

    private static final String API_KEY = "d0e16fe7e7812e34e97841781fd5c04e";
    private static final String API_LANG = "en";
    private static ITmdbService instance;
    private final TmdbApi tmdbApi;
    private final TmdbTV tvSeries;
    private TmdbMovies tmdbMovies;

    public TmdbService() {
        tmdbApi = new TmdbApi(API_KEY);
        tmdbMovies = tmdbApi.getMovies();
        tvSeries = tmdbApi.getTvSeries();
    }

    public static ITmdbService getInstance() {
        if (instance == null) {
            instance = new TmdbService();
        }
        return instance;
    }

    @Override
    public MovieResultsPage getNowPlayingMovies(int page) {
        return tmdbMovies.getNowPlayingMovies(API_LANG, page);
    }

    @Override
    public MovieResultsPage getUpcomingMovies(int page) {
        return tmdbMovies.getUpcoming(API_LANG, page);
    }

    @Override
    public MovieResultsPage getPopularMovies(int page) {
        return tmdbMovies.getPopularMovies(API_LANG, page);
    }

    @Override
    public MovieResultsPage getTopRatedMovies(int page) {
        return tmdbMovies.getTopRatedMovies(API_LANG, page);
    }

    @Override
    public TvResultsPage getAiringTodayTV(int page) {
        return tvSeries.getAiringToday(API_LANG, page, null);
    }

    @Override
    public TvResultsPage getOnTV(int page) {
        return tvSeries.getOnTheAir(API_LANG, page);
    }

    @Override
    public TvResultsPage getPopularTV(int page) {
        return tvSeries.getPopular(API_LANG, page);
    }

    @Override
    public TvResultsPage getTopRatedTV(int page) {
        return tvSeries.getTopRated(API_LANG, page);
    }
}
