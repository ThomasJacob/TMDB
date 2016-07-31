package viewModels;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by thomas on 7/31/2016.
 */
public class TopRatedCollection extends MovieCollection {
    public TopRatedCollection() {
        super(getString(R.string.topRated));
    }

    @Override
    public List<MovieDb> getList() {
        return TmdbService.getInstance().getTopRatedMovies(0).getResults();
    }
}
