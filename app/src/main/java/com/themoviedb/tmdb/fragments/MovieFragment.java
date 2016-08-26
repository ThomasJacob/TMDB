package com.themoviedb.tmdb.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.adapters.MovieListAdapter;
import com.themoviedb.tmdb.databinding.FragmentMovieBinding;

import framework.viewModelBase.CollectionViewModel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MovieFragment extends Fragment {

    public CollectionViewModel collectionViewModel;
    private FragmentMovieBinding fragmentViewBinding;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        fragmentViewBinding.mainRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getContext().getResources().getInteger(R.integer.column_count), GridLayoutManager.VERTICAL, false));
        setSource();
        return fragmentViewBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setSource();
    }

    private void setSource() {
        if (fragmentViewBinding != null && collectionViewModel != null) {
            fragmentViewBinding.setVariable(com.themoviedb.tmdb.BR.viewModel, collectionViewModel);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    collectionViewModel.initialize();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            fragmentViewBinding.mainRecyclerView.setAdapter(new MovieListAdapter(collectionViewModel.getItems()));
                        }
                    });
                }
            };
            AsyncTask.execute(runnable);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
