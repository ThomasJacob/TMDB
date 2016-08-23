package framework.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import framework.core.ViewModelLoader;
import framework.interfaces.IViewModelFactory;
import framework.viewModelBase.ViewModelBase;

public abstract class BaseActivity<T extends ViewModelBase> extends AppCompatActivity implements LoaderManager.LoaderCallbacks<T> {

    private static final int LOADER_ID = 101;
    private T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
//        viewModel.onViewAttached();
        super.onStart();
    }

    @Override
    protected void onStop() {
//        viewModel.onViewDetached();
        super.onStop();
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

    public T getViewModel() {
        return viewModel;
    }

    protected void raiseViewModelLoaded() {
    }

    protected abstract IViewModelFactory<T> getViewModelFactory();
}
