package com.themoviedb.tmdb;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class BindingViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding viewDataBinding;

    public BindingViewHolder(ViewDataBinding viewBinding) {
        super(viewBinding.getRoot());
        viewDataBinding = viewBinding;
    }

    public ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }
}
