package viewModels.movie;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by thomas on 7/31/2016.
 */
public class UpcomingCollection extends MovieCollection {
    public UpcomingCollection() {
        super(getString(R.string.upcoming));
    }

    @Override
    public List<MovieDb> getList() {
        return TmdbService.getInstance().getUpcomingMovies(0).getResults();
    }

}
