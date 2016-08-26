package framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.google.common.eventbus.Subscribe;
import com.themoviedb.tmdb.BaseFragment;

import framework.core.ViewModelLoader;
import framework.interfaces.IViewModelFactory;
import framework.utils.EventService;
import framework.utils.NavigateMessage;
import framework.viewModelBase.ViewModelBase;

public abstract class BaseActivity<T extends ViewModelBase> extends AppCompatActivity implements LoaderManager.LoaderCallbacks<T>, BaseFragment.IViewModelListener<T> {

    private static final int LOADER_ID = 101;
    private T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    protected void onPostResume() {
        EventService.getInstance().getBus().register(this);
        super.onPostResume();
        ViewModelBase vm = getViewModel();
        if (vm != null) {
            vm.onViewAttached();
        }
    }

    @Override
    protected void onStop() {
        EventService.getInstance().getBus().unregister(this);
        super.onStop();
        ViewModelBase vm = getViewModel();
        if (vm != null) {
            vm.onViewDetached();
        }
    }

    @Override
    public Loader<T> onCreateLoader(int id, Bundle args) {
        return new ViewModelLoader<T>(this, getViewModelFactory());
    }

    @Override
    public void onLoadFinished(Loader<T> loader, T data) {
        this.viewModel = data;
        raiseViewModelLoaded();
    }

    @Override
    public void onLoaderReset(Loader<T> loader) {
        this.viewModel = null;
    }

    public T getBaseViewModel() {
        return getViewModel();
    }

    public T getViewModel() {
        return viewModel;
    }

    protected void raiseViewModelLoaded() {
        EventService.getInstance().getBus().post(getViewModel());
    }

    protected abstract IViewModelFactory<T> getViewModelFactory();

    @Subscribe
    public void startActivity(NavigateMessage navigateMessage) {
        Intent navigationIntent = new Intent(this, navigateMessage.getActivityType());
        startActivity(navigationIntent);
    }
}
