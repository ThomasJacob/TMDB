package com.themoviedb.tmdb;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.themoviedb.tmdb.databinding.HomeViewBinding;

import java.util.ArrayList;
import java.util.List;

import viewModels.HomeViewModel;
import viewModels.MovieViewModel;

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
        final HomeViewModel homeVM = homeViewModel;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                homeViewModel.initialize();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        homeViewBinding.mainViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

                            List<List<MovieViewModel>> moviesList = getList();

                            @NonNull
                            private ArrayList<List<MovieViewModel>> getList() {
                                ArrayList<List<MovieViewModel>> movies = new ArrayList<>();
                                movies.add(homeViewModel.getMovieCollection());
                                movies.add(homeViewModel.getMovieCollection());
                                movies.add(homeViewModel.getMovieCollection());
                                return movies;
                            }

                            @Override
                            public Fragment getItem(int position) {
                                return new MovieFragment() {
                                };
                            }

                            @Override
                            public int getCount() {
                                return moviesList.size();
                            }
                        });
//                        homeViewBinding.mainRecyclerView.setAdapter(new MovieListAdapter(homeViewModel.getMovieCollection()));
                    }
                });
            }
        };
        AsyncTask.execute(runnable);
    }

    @Override
    public HomeViewModel getHomeViewModel() {
        return homeViewModel;
    }
}
