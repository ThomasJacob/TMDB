package framework.viewModelBase;

import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import framework.application.ApplicationBase;
import framework.interfaces.IPresenter;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class ViewModelBase implements IPresenter {
    public ObservableBoolean isBusy = new ObservableBoolean();

    @NonNull
    public static String getString(int id) {
        return ApplicationBase.getAppContext().getString(id);
    }

    public void initialize() {
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }
}

