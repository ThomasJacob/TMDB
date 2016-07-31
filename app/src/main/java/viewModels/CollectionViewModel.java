package viewModels;

import java.util.List;

/**
 * Created by thomas on 7/31/2016.
 */
public class CollectionViewModel<T, K> extends ViewModelBase {
    private List<T> items;
    private String title;

    public CollectionViewModel(String title) {
        setTitle(title);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

