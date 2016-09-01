package viewModels;

import framework.viewModelBase.ViewModelBase;

/**
 * Created by Thomas.Jacob on 8/1/2016.
 */
public class ItemViewModel extends ViewModelBase {

    private String title;
    private String posterImageUri;
    private String backdropImageUri;

    public String getPosterImageUri() {
        return posterImageUri;
    }

    public void setPosterImageUri(String posterImageUri) {
        this.posterImageUri = posterImageUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropImageUri() {
        return backdropImageUri;
    }

    public void setBackdropImageUri(String backdropImageUri) {
        this.backdropImageUri = backdropImageUri;
    }
}
