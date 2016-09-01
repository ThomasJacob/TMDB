package viewModels;

import framework.viewModelBase.ViewModelBase;
import viewModels.movie.NowPlayingCollection;
import viewModels.tv.OnTVCollection;

/**
 * Created by Thomas.Jacob on 9/1/2016.
 */
public class SpotlightViewModel extends ViewModelBase {
    private NowPlayingCollection nowPlayingCollection;
    private OnTVCollection onTVCollection;

    public SpotlightViewModel() {
        nowPlayingCollection = new NowPlayingCollection();
        onTVCollection = new OnTVCollection();
    }

    public OnTVCollection getOnTVCollection() {
        return onTVCollection;
    }

    public NowPlayingCollection getNowPlayingCollection() {
        return nowPlayingCollection;
    }
}
