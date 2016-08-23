package viewModels.viewModelBase;

import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;
import android.view.View;

import application.ApplicationBase;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class ViewModelBase implements IPresenter<View> {
    public ObservableBoolean isBusy = new ObservableBoolean();

    @NonNull
    public static String getString(int id) {
        return ApplicationBase.getAppContext().getString(id);
    }

    public void initialize() {
    }

    @Override
    public void onViewAttached(View view) {

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }
}

