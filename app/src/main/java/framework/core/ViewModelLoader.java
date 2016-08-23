package framework.core;

import android.content.Context;
import android.support.v4.content.Loader;

import framework.interfaces.IViewModelFactory;
import framework.interfaces.IPresenter;

/**
 * Created by Thomas.Jacob on 8/22/2016.
 */
public class ViewModelLoader<T extends IPresenter> extends Loader<T> {

    private final IViewModelFactory<T> factory;
    private T viewModel;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public ViewModelLoader(Context context, IViewModelFactory<T> factory) {
        super(context);
        this.factory = factory;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (viewModel != null) {
            deliverResult(viewModel);
            return;
        }
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
//        super.onForceLoad();
        viewModel = factory.create();
        deliverResult(viewModel);
    }

    @Override
    protected void onReset() {
        viewModel.onDestroyed();
        viewModel = null;
//        super.onReset();
    }

    public T getViewModel() {
        return viewModel;
    }

    private void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }
}
