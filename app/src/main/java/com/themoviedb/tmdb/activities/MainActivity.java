package com.themoviedb.tmdb.activities;

import android.database.Observable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.themoviedb.tmdb.R;
import com.themoviedb.tmdb.databinding.ActivityMainBinding;
import com.themoviedb.tmdb.fragments.MovieContentFragment;
import com.themoviedb.tmdb.fragments.TVContentFragment;

import framework.activity.BaseActivity;
import framework.interfaces.IViewModelFactory;
import viewModels.HomeViewModel;

public class MainActivity extends BaseActivity<HomeViewModel>
        implements NavigationView.OnNavigationItemSelectedListener {


    private Observable<String> MovieName;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(activityMainBinding.toolbar);
        DrawerLayout drawer = activityMainBinding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, activityMainBinding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = activityMainBinding.navView;
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void postViewModelLoaded() {
        super.postViewModelLoaded();
        NavigationView navigationView = activityMainBinding.navView;
        MenuItem selectedMenu = navigationView.getMenu().findItem((getViewModel().getSelectedNavId()));
        onNavigationItemSelected(selectedMenu);
        navigationView.setCheckedItem(selectedMenu.getItemId());
    }

    @Override
    protected IViewModelFactory<HomeViewModel> getViewModelFactory() {
        return new IViewModelFactory<HomeViewModel>() {
            @Override
            public HomeViewModel create() {
                return new HomeViewModel();
            }
        };
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = activityMainBinding.drawerLayout;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        getViewModel().setSelectedNavId(id);

        if (id == R.id.movie_item) {
            MovieContentFragment fragment = new MovieContentFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainContent, fragment);
            fragmentTransaction.commit();
            // Handle the camera action
        } else if (id == R.id.tv_item) {
            TVContentFragment fragment = new TVContentFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainContent, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.discover_item) {

        } else if (id == R.id.people_item) {

        }

        activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
