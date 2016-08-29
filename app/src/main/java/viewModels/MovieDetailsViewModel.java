package viewModels;

import com.google.gson.Gson;

import framework.viewModelBase.ViewModelBase;
import viewModels.movie.MovieItemViewModel;

/**
 * Created by Thomas.Jacob on 8/29/2016.
 */
public class MovieDetailsViewModel extends ViewModelBase {
    private MovieItemViewModel movieItem;

    @Override
    public void initialize() {
        super.initialize();
        String navInfo = getNavigationInfo();
        if (navInfo != null) {
            Gson gson = new Gson();
            movieItem = gson.fromJson(navInfo, MovieItemViewModel.class);
        }
    }

    public MovieItemViewModel getMovieItem() {
        return movieItem;
    }
}
