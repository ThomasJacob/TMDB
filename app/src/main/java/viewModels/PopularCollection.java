package viewModels;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by thomas on 7/31/2016.
 */
public class PopularCollection extends MovieCollection {
    public PopularCollection() {
        super(getString(R.string.popular));
    }

    @Override
    public List<MovieDb> getList() {
        return TmdbService.getInstance().getPopularMovies(0).getResults();
    }
}
