package com.themoviedb.tmdb.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.ContentDetailsBinding;

import framework.activity.BaseActivity;
import framework.interfaces.IViewModelFactory;
import viewModels.MovieDetailsViewModel;

public class DetailsActivity extends BaseActivity<MovieDetailsViewModel> {

    private ContentDetailsBinding contentDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentDetailsBinding = DataBindingUtil.setContentView(this, R.layout.content_details);
    }

    @Override
    protected void postViewModelLoaded() {
        super.postViewModelLoaded();
        contentDetailsBinding.setViewModel(getViewModel());
    }

    @Override
    protected IViewModelFactory<MovieDetailsViewModel> getViewModelFactory() {
        return new IViewModelFactory<MovieDetailsViewModel>() {
            @Override
            public MovieDetailsViewModel create() {
                return new MovieDetailsViewModel();
            }
        };
    }
}
