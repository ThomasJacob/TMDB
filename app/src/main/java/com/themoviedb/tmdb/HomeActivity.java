package com.themoviedb.tmdb;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.themoviedb.tmdb.databinding.HomeViewBinding;

import java.util.List;

import viewModels.HomeViewModel;
import viewModels.MovieCollection;

public class HomeActivity extends AppCompatActivity implements MovieFragment.OnFragmentInteractionListener {

    public HomeViewModel homeViewModel;

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, String url) {
        Picasso.with(view.getContext()).load(url).fit().into(view);
    }

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
                fragment.movieCollection = getMovieList().get(position);
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

    @Override
    public HomeViewModel getHomeViewModel() {
        return homeViewModel;
    }
}
