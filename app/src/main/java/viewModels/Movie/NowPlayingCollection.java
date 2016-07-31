package viewModels.movie;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.MovieDb;

/**
 * Created by thomas on 7/31/2016.
 */
public class NowPlayingCollection extends MovieCollection {
    public NowPlayingCollection() {
        super(getString(R.string.nowPlaying));
    }

    @Override
    public List<MovieDb> getList() {
        return TmdbService.getInstance().getNowPlayingMovies(0).getResults();
    }
}
