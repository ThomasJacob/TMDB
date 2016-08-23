package com.themoviedb.tmdb.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.HomeViewBinding;
import com.themoviedb.tmdb.fragments.MovieFragment;

import java.util.List;

import viewModels.HomeViewModel;
import viewModels.movie.MovieCollection;

public class HomeActivity extends AppCompatActivity {

    public HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel = new HomeViewModel();
        final HomeViewBinding homeViewBinding = DataBindingUtil.setContentView(this, R.layout.home_view);
        homeViewBinding.setVariable(com.themoviedb.tmdb.BR.viewModel, homeViewModel);

        homeViewBinding.mainViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            public List<MovieCollection> getMovieList() {
                return homeViewModel.getMovieCollections();
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

        homeViewBinding.mainTabLayout.setupWithViewPager(homeViewBinding.mainViewPager);
    }
}

