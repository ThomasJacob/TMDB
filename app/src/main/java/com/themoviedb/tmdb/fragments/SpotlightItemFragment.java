package com.themoviedb.tmdb.fragments;


import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themoviedb.tmdb.BR;
import com.themoviedb.tmdb.BaseFragment;
import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.FragmentSpotlightItemBinding;

import viewModels.ItemViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpotlightItemFragment extends BaseFragment {

    FragmentSpotlightItemBinding fragmentSpotlightItemBinding;
    private ItemViewModel itemViewModel;

    public SpotlightItemFragment() {
    }

    @SuppressLint("ValidFragment")
    public SpotlightItemFragment(ItemViewModel itemViewModel) {
        this.itemViewModel = itemViewModel;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSpotlightItemBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_spotlight_item, container, false);
        fragmentSpotlightItemBinding.setVariable(BR.viewModel, itemViewModel);
        return fragmentSpotlightItemBinding.getRoot();
    }

}
