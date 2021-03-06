package com.themoviedb.tmdb.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themoviedb.tmdb.BindingViewHolder;
import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.activities.DetailsActivity;

import java.util.List;

import framework.utils.EventService;
import viewModels.ItemViewModel;

/**
 * Created by Thomas.Jacob on 6/17/2016.
 */
public class MovieListAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private List<ItemViewModel> items;

    public MovieListAdapter(List<ItemViewModel> items) {
        this.items = items;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_item, parent, false);
        return new BindingViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, final int position) {
        ViewDataBinding viewBinding = holder.getViewDataBinding();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventService.getInstance().navigate(DetailsActivity.class, items.get(position));
            }
        });
        viewBinding.executePendingBindings();
        viewBinding.setVariable(com.themoviedb.tmdb.BR.viewModel, items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}

