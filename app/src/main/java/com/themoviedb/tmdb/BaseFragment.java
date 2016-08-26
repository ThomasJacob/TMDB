package com.themoviedb.tmdb;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.google.common.eventbus.Subscribe;

import framework.utils.EventService;
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
        EventService.getInstance().getBus().unregister(this);
        super.onPause();
    }

    @Override
    public void onResume() {
        EventService.getInstance().getBus().register(this);
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
