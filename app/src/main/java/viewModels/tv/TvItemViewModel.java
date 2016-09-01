package viewModels.tv;

import info.movito.themoviedbapi.model.tv.TvSeries;
import viewModels.ItemViewModel;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class TVItemViewModel extends ItemViewModel {
    public TVItemViewModel(TvSeries tvSeries) {
        setTitle(tvSeries.getName());
        setImageUri("https://image.tmdb.org/t/p/w185" + tvSeries.getPosterPath());
        setPosterImageUri("https://image.tmdb.org/t/p/w185" + tvSeries.getBackdropPath());
    }
}
