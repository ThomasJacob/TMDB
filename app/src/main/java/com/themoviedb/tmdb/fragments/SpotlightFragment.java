package com.themoviedb.tmdb.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.themoviedb.tmdb.BR;
import com.themoviedb.tmdb.BaseFragment;
import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.FragmentSpotlightBinding;

import java.util.List;

import framework.viewModelBase.CollectionViewModel;
import viewModels.HomeViewModel;
import viewModels.ItemViewModel;
import viewModels.SpotlightViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpotlightFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpotlightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpotlightFragment extends BaseFragment<HomeViewModel> {

    private FragmentSpotlightBinding fragmentSpotlightBinding;
    private SpotlightViewModel spotlightViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSpotlightBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_spotlight, container, false);
        SetData();
        return fragmentSpotlightBinding.getRoot();
    }

    @Override
    public void viewModelLoaded(HomeViewModel viewModel) {
        super.viewModelLoaded(viewModel);
        SetData();
    }

    private void SetData() {
        HomeViewModel viewModel = getViewModel();
        if (viewModel != null && fragmentSpotlightBinding != null) {
            spotlightViewModel = viewModel.getSpotlightViewModel();
            fragmentSpotlightBinding.setVariable(BR.viewModel, spotlightViewModel);
            fragmentSpotlightBinding.mediaViewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    CollectionViewModel collectionViewModel = getCollectionViewModel(position);
                    MovieFragment fragment = new MovieFragment();
                    fragment.collectionViewModel = collectionViewModel;
                    return fragment;
                }

                @Override
                public int getCount() {
                    return 2;
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return getCollectionViewModel(position).getTitle();
                }
            });
            fragmentSpotlightBinding.mediaViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    final CollectionViewModel collectionViewModel = getCollectionViewModel(position);
                    if (collectionViewModel != null) {
                        List mediaItems = collectionViewModel.getItems();
                        if (mediaItems != null) {
                            final List topItems = mediaItems.subList(0, 5);
                            fragmentSpotlightBinding.spotlighttViewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
                                @Override
                                public Fragment getItem(int position) {
                                    ItemViewModel itemViewModel = (ItemViewModel) topItems.get(position);
                                    if (itemViewModel != null) {
                                        return new SpotlightItemFragment(itemViewModel);
                                    }
                                    return null;
                                }

                                @Override
                                public int getCount() {
                                    return topItems.size();
                                }
                            });
                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            fragmentSpotlightBinding.mainTabLayout.setupWithViewPager(fragmentSpotlightBinding.mediaViewPager);
        }
    }

    private CollectionViewModel getCollectionViewModel(int position) {
        CollectionViewModel collectionViewModel = null;
        if (position == 0) {
            collectionViewModel = spotlightViewModel.getNowPlayingCollection();
        } else {
            collectionViewModel = spotlightViewModel.getOnTVCollection();
        }
        return collectionViewModel;
    }
}
