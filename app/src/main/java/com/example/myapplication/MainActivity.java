package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.fragment.ClassFragment;
import com.example.myapplication.fragment.DirectorFragment;
import com.example.myapplication.fragment.FavoriteFragment;
import com.example.myapplication.fragment.HelpFragment;
import com.example.myapplication.fragment.HotSearchFragment;
import com.example.myapplication.fragment.NewUpdateFragment;
import com.example.myapplication.fragment.PetFragment;
import com.example.myapplication.fragment.QuizFragment;
import com.example.myapplication.fragment.ScientFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    public static final String url = "https://www.google.com";

    private static final int CLASS_FRAGMENT = 0;
    private static final int NEW_UPDATE_FRAGMENT = 1;
    private static final int HOT_SEARCH_FRAGMENT = 2;
    private static final int FAVORITE_FRAGMENT = 3;
    private static final int SCIENT_FRAGMENT = 4;
    private static final int QUIZ_FRAGMENT = 5;
    private static final int PET_FRAGMENT = 6;
    private static final int HELP_FRAGMENT = 7;
    private static final int DIRECTOR_FRAGMENT = 8;


    private int mCurrentFragment = CLASS_FRAGMENT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.main_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);

    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.systembar_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_kp){
            if(mCurrentFragment != CLASS_FRAGMENT){
                replaceFragment(new ClassFragment());
                mCurrentFragment = CLASS_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.main_layout_custom);
            }
        } else if (id == R.id.nav_dvm) {
            if(mCurrentFragment != NEW_UPDATE_FRAGMENT){
                replaceFragment(new NewUpdateFragment());
                mCurrentFragment = NEW_UPDATE_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.new_update_layout_custom);
            }
        } else if (id == R.id.nav_gmnb) {
            if(mCurrentFragment != HOT_SEARCH_FRAGMENT){
                replaceFragment(new HotSearchFragment());
                mCurrentFragment = HOT_SEARCH_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.hot_search_layout_custom);
            }
        } else if (id == R.id.nav_dsyt) {
            if(mCurrentFragment != FAVORITE_FRAGMENT){
                replaceFragment(new FavoriteFragment());
                mCurrentFragment = FAVORITE_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.favorite_layout_custom);
            }
        } else if (id == R.id.nav_eykh) {
            if(mCurrentFragment != SCIENT_FRAGMENT){
                replaceFragment(new ScientFragment());
                mCurrentFragment = SCIENT_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.scient_layout_custom);
            }
        } else if (id == R.id.nav_dv) {
            if(mCurrentFragment != QUIZ_FRAGMENT){
                replaceFragment(new QuizFragment());
                mCurrentFragment = QUIZ_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.quiz_layout_custom);
            }
        } else if (id == R.id.nav_cstc) {
            if(mCurrentFragment != PET_FRAGMENT){
                replaceFragment(new PetFragment());
                mCurrentFragment = PET_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.pet_layout_custom);
            }
        } else if (id == R.id.nav_hd) {
            if(mCurrentFragment != HELP_FRAGMENT){
                replaceFragment(new HelpFragment());
                mCurrentFragment = HELP_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.help_layout_custom);
            }
        } else if (id == R.id.nav_tg) {
            if(mCurrentFragment != DIRECTOR_FRAGMENT){
                replaceFragment(new DirectorFragment());
                mCurrentFragment = DIRECTOR_FRAGMENT;
                getSupportActionBar().setCustomView(R.layout.director_layout_custom);
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){

    }
}

