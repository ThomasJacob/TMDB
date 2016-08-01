package viewModels;

import viewModels.viewModelBase.ViewModelBase;

/**
 * Created by Thomas.Jacob on 8/1/2016.
 */
public class ItemViewModel extends ViewModelBase {

    private String title;
    private String imageUri;

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
