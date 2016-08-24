package com.themoviedb.tmdb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.squareup.otto.Subscribe;

import framework.utils.EventBus;
import viewModels.HomeViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment<T> extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onPause() {
        EventBus.getInstance().getBus().unregister(this);
        super.onPause();
    }

    @Override
    public void onResume() {
        EventBus.getInstance().getBus().register(this);
        super.onResume();
    }

    @Subscribe
    public void viewModelLoaded(HomeViewModel viewModel) {
        // TODO: React to the event somehow!
    }

    public T getViewModel() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return ((IViewModelListener<T>) activity).getBaseViewModel();
        }
        return null;
    }

    public interface IViewModelListener<T> {
        T getBaseViewModel();
    }

}
