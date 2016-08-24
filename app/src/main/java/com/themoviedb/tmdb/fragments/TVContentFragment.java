package com.themoviedb.tmdb.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.themoviedb.tmdb.BaseFragment;
import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.MovieViewBinding;

import java.util.List;

import viewModels.HomeViewModel;
import viewModels.TVViewModel;
import viewModels.tv.TVCollection;

/**
 * Created by Thomas.Jacob on 8/1/2016.
 */
public class TVContentFragment extends BaseFragment<HomeViewModel> {
    private TVViewModel tvViewModel;
    private MovieViewBinding movieContentBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        movieContentBinding = DataBindingUtil.inflate(inflater, R.layout.movie_view, container, false);
        return movieContentBinding.getRoot();
    }

    @Override
    public void onResume() {
        setViewData();
        super.onResume();
    }

    @Subscribe
    @Override
    public void viewModelLoaded(HomeViewModel viewModel) {
        super.viewModelLoaded(viewModel);
        setViewData();
    }

    private void setViewData() {
        HomeViewModel vm = getViewModel();
        if (vm != null) {
            tvViewModel = getViewModel().getTvViewModel();

            movieContentBinding.setVariable(com.themoviedb.tmdb.BR.viewModel, tvViewModel);

            movieContentBinding.mainViewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {

                public List<TVCollection> getTvList() {
                    return tvViewModel.getTvCollections();
                }

                @Override
                public Fragment getItem(int position) {
                    MovieFragment fragment = new MovieFragment();
                    fragment.collectionViewModel = getTvList().get(position);
                    return fragment;
                }

                @Override
                public int getCount() {
                    return getTvList().size();
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return getTvList().get(position).getTitle();
                }
            });

            movieContentBinding.mainTabLayout.setupWithViewPager(movieContentBinding.mainViewPager);
        }
    }
}
