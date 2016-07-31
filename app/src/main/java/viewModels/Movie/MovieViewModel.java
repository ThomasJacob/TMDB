package viewModels.movie;

import info.movito.themoviedbapi.model.MovieDb;
import viewModels.viewModelBase.ViewModelBase;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class MovieViewModel extends ViewModelBase {

    private String title;
    private String imageUri;

    public MovieViewModel(MovieDb movie) {
        setTitle(movie.getTitle());
        setImageUri("https://image.tmdb.org/t/p/w185" + movie.getPosterPath());
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
