package viewModels.tv;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.model.tv.TvSeries;
import viewModels.viewModelBase.CollectionViewModel;

/**
 * Created by thomas on 7/31/2016.
 */
public abstract class TVCollection extends CollectionViewModel<TVItemViewModel, TvSeries> {
    private boolean isLoaded;

    public TVCollection(String title) {
        super(title);
    }

    @Override
    public void initialize() {
        super.initialize();
        if (!isLoaded && !isBusy.get()) {
            isBusy.set(true);
            loadMovies();
            isBusy.set(false);
        }
    }

    private void loadMovies() {
        createItemList(getList());
    }

    private void createItemList(List<TvSeries> tvSeriesList) {
        List<TVItemViewModel> tvItems = new ArrayList<>();
        for (TvSeries tvSeries : tvSeriesList) {
            TVItemViewModel movieItemViewModel = new TVItemViewModel(tvSeries);
            tvItems.add(movieItemViewModel);
        }
        setItems(tvItems);
        isLoaded = true;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
