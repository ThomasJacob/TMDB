package viewModels.tv;

import api.TmdbService;
import info.movito.themoviedbapi.model.tv.TvSeries;
import viewModels.ItemViewModel;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class TVItemViewModel extends ItemViewModel {
    public TVItemViewModel(TvSeries tvSeries) {
        setTitle(tvSeries.getName());
        setPosterImageUri(TmdbService.BasePosterImage + tvSeries.getPosterPath());
        setBackdropImageUri(TmdbService.BaseBackdropImage + tvSeries.getBackdropPath());
    }
}
