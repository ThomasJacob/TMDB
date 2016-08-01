package com.themoviedb.tmdb.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.MovieViewBinding;

import java.util.List;

import viewModels.MovieViewModel;
import viewModels.movie.MovieCollection;

/**
 * Created by thomas on 7/31/2016.
 */
public class MovieContentFragment extends Fragment {

    private MovieViewModel movieViewModel;
    private MovieViewBinding movieContentBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        movieViewModel = new MovieViewModel();
        movieContentBinding = DataBindingUtil.inflate(inflater, R.layout.movie_view, container, false);
        movieContentBinding.setVariable(com.themoviedb.tmdb.BR.viewModel, movieViewModel);

        movieContentBinding.mainViewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {

            public List<MovieCollection> getMovieList() {
                return movieViewModel.getMovieCollections();
            }

            @Override
            public Fragment getItem(int position) {
                MovieFragment fragment = new MovieFragment();
                fragment.collectionViewModel = getMovieList().get(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return getMovieList().size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getMovieList().get(position).getTitle();
            }
        });

        movieContentBinding.mainTabLayout.setupWithViewPager(movieContentBinding.mainViewPager);
        return movieContentBinding.getRoot();
    }
}