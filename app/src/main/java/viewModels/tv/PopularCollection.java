package viewModels.tv;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.tv.TvSeries;

/**
 * Created by thomas on 7/31/2016.
 */
public class PopularCollection extends TVCollection {
    public PopularCollection() {
        super(getString(R.string.popular));
    }

    @Override
    public List<TvSeries> getList() {
        return TmdbService.getInstance().getPopularTV(0).getResults();
    }
}
