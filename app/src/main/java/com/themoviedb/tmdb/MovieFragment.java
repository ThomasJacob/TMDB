package com.themoviedb.tmdb;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themoviedb.tmdb.databinding.FragmentMovieBinding;

import viewModels.HomeViewModel;
import viewModels.MovieCollection;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MovieFragment extends Fragment {

    public MovieCollection movieCollection;
    private OnFragmentInteractionListener mListener;
    private FragmentMovieBinding fragmentViewBinding;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        fragmentViewBinding.mainRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        setSource();
        return fragmentViewBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        setSource();
    }

    private void setSource() {
        if (mListener != null && fragmentViewBinding != null) {
            fragmentViewBinding.setVariable(com.themoviedb.tmdb.BR.viewModel, movieCollection);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    movieCollection.initialize();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            fragmentViewBinding.mainRecyclerView.setAdapter(new MovieListAdapter(movieCollection.getItems()));
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
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        HomeViewModel getHomeViewModel();
    }
}
