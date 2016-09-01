package viewModels;

import com.themoviedb.tmdb.R;

import framework.viewModelBase.ViewModelBase;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class HomeViewModel extends ViewModelBase {
    private MovieViewModel movieViewModel;
    private TVViewModel tvViewModel;
    private SpotlightViewModel spotlightViewModel;
    private int selectedNavId = R.id.spotlight_item;

    public HomeViewModel() {
        movieViewModel = new MovieViewModel();
        tvViewModel = new TVViewModel();
        spotlightViewModel = new SpotlightViewModel();
    }

    @Override
    public void initialize() {
        super.initialize();
        isBusy.set(true);
        isBusy.set(false);
    }

    public TVViewModel getTvViewModel() {
        return tvViewModel;
    }

    public MovieViewModel getMovieViewModel() {
        return movieViewModel;
    }

    public int getSelectedNavId() {
        return selectedNavId;
    }

    public void setSelectedNavId(int selectedNavId) {
        this.selectedNavId = selectedNavId;
    }

    public SpotlightViewModel getSpotlightViewModel() {
        return spotlightViewModel;
    }
}
