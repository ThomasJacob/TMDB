package viewModels.viewModelBase;

import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import application.ApplicationBase;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class ViewModelBase {
    public ObservableBoolean isBusy = new ObservableBoolean();

    @NonNull
    public static String getString(int id) {
        return ApplicationBase.getAppContext().getString(id);
    }

    public void initialize() {
    }
}
