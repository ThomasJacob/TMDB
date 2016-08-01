package viewModels.tv;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.tv.TvSeries;

/**
 * Created by thomas on 7/31/2016.
 */
public class TopRatedCollection extends TVCollection {
    public TopRatedCollection() {
        super(getString(R.string.topRated));
    }

    @Override
    public List<TvSeries> getList() {
        return TmdbService.getInstance().getTopRatedTV(0).getResults();
    }
}
