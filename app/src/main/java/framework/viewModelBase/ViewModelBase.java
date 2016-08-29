package framework.viewModelBase;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import framework.application.ApplicationBase;
import framework.interfaces.IPresenter;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class ViewModelBase extends BaseObservable implements IPresenter {
    public ObservableBoolean isBusy = new ObservableBoolean();

    private boolean isInitialized;
    private String navigationInfo;

    @NonNull
    public static String getString(int id) {
        return ApplicationBase.getAppContext().getString(id);
    }

    public void initialize() {
    }

    @Override
    public void onViewAttached() {
        if (!isInitialized()) {
            initialize();
            setInitialized(true);
        }
    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onDestroyed() {

    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    public String getNavigationInfo() {
        return navigationInfo;
    }

    public void setNavigationInfo(String navigationInfo) {
        this.navigationInfo = navigationInfo;
    }
}

