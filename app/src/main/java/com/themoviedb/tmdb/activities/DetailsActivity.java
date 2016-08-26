package com.themoviedb.tmdb.activities;

import android.os.Bundle;

import com.themoviedb.tmdb.R;

import framework.activity.BaseActivity;
import framework.interfaces.IViewModelFactory;
import info.movito.themoviedbapi.model.MovieDb;
import viewModels.movie.MovieItemViewModel;

public class DetailsActivity extends BaseActivity<MovieItemViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_details);
    }

    @Override
    protected IViewModelFactory<MovieItemViewModel> getViewModelFactory() {
        return new IViewModelFactory<MovieItemViewModel>() {
            @Override
            public MovieItemViewModel create() {
                return new MovieItemViewModel(new MovieDb());
            }
        };
    }

}
