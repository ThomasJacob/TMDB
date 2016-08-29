package framework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

    public static final String NAVIGATION_INFO = "NAVIGATION_INFO";
    private static final int LOADER_ID = 101;
    private T viewModel;
    private String navgiationInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent navigationIntent = getIntent();
        if (navigationIntent != null && navigationIntent.hasExtra(NAVIGATION_INFO)) {
            navgiationInfo = navigationIntent.getExtras().getString(NAVIGATION_INFO);
        }
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    protected void onPostResume() {
        EventService.getInstance().getBus().register(this);
        super.onPostResume();
        ViewModelBase vm = getViewModel();
        if (vm != null) {
            vm.setNavigationInfo(navgiationInfo);
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
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                postViewModelLoaded();
            }
        });
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

    protected void postViewModelLoaded() {
        EventService.getInstance().getBus().post(getViewModel());
    }

    protected abstract IViewModelFactory<T> getViewModelFactory();

    @Subscribe
    public void startActivity(NavigateMessage navigateMessage) {
        Intent navigationIntent = new Intent(this, navigateMessage.getActivityType());
        navigationIntent.putExtra(NAVIGATION_INFO, navigateMessage.getNavigationData());
        startActivity(navigationIntent);
    }
}
