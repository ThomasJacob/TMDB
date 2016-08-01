package viewModels;

import java.util.ArrayList;
import java.util.List;

import viewModels.tv.AiringTodayCollection;
import viewModels.tv.OnTVCollection;
import viewModels.tv.PopularCollection;
import viewModels.tv.TVCollection;
import viewModels.tv.TopRatedCollection;
import viewModels.viewModelBase.ViewModelBase;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class TVViewModel extends ViewModelBase {
    private List<TVCollection> tvCollections;

    @Override
    public void initialize() {
        super.initialize();
    }

    public List<TVCollection> getTvCollections() {
        if (tvCollections == null) {
            tvCollections = new ArrayList<>();
            tvCollections.add(new AiringTodayCollection());
            tvCollections.add(new OnTVCollection());
            tvCollections.add(new PopularCollection());
            tvCollections.add(new TopRatedCollection());
        }
        return tvCollections;
    }
}
