package viewModels.tv;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.tv.TvSeries;

/**
 * Created by thomas on 7/31/2016.
 */
public class OnTVCollection extends TVCollection {
    public OnTVCollection() {
        super(getString(R.string.onTV));
    }

    @Override
    public List<TvSeries> getList() {
        return TmdbService.getInstance().getOnTV(0).getResults();
    }
}
