package viewModels.tv;

import com.themoviedb.tmdb.R;

import java.util.List;

import api.TmdbService;
import info.movito.themoviedbapi.model.tv.TvSeries;

/**
 * Created by thomas on 7/31/2016.
 */
public class AiringTodayCollection extends TVCollection {
    public AiringTodayCollection() {
        super(getString(R.string.airingToday));
    }

    @Override
    public List<TvSeries> getList() {
        return TmdbService.getInstance().getAiringTodayTV(0).getResults();
    }
}
