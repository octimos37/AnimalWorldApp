package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.Species.Canidae.CanidaeActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    private ImageView imageView;

    public static final String url = "https://www.google.com";

    private static final int CLASS_ACTIVITY = 0;
    private static final int NEW_UPDATE_ACTIVITY = 1;
    private static final int HOT_SEARCH_ACTIVITY = 2;
    private static final int FAVORITE_ACTIVITY = 3;
    private static final int SCIENT_ACTIVITY = 4;
    private static final int QUIZ_ACTIVITY = 5;
    private static final int PET_ACTIVITY = 6;
    private static final int HELP_ACTIVITY = 7;
    private static final int DIRECTOR_ACTIVITY = 8;


    private int mCurrentActivity = CLASS_ACTIVITY;



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

        //replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);

        imageView = findViewById(R.id.ivDongvatcovu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MammalsActivity.class);
                startActivity(intent);
            }
        });

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

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                getSupportActionBar().setCustomView(R.layout.main_layout_custom);

        } else if (id == R.id.nav_dvm) {

                Intent i = new Intent(getApplicationContext(), CanidaeActivity.class);
                startActivity(i);
                getSupportActionBar().setCustomView(R.layout.canidae_layout_custom);

        } //else if (id == R.id.nav_gmnb) {
//            if(mCurrentFragment != HOT_SEARCH_FRAGMENT){
//                replaceFragment(new HotSearchFragment());
//                mCurrentFragment = HOT_SEARCH_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.hot_search_layout_custom);
//            }
//        } else if (id == R.id.nav_dsyt) {
//            if(mCurrentFragment != FAVORITE_FRAGMENT){
//                replaceFragment(new FavoriteFragment());
//                mCurrentFragment = FAVORITE_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.favorite_layout_custom);
//            }
//        } else if (id == R.id.nav_eykh) {
//            if(mCurrentFragment != SCIENT_FRAGMENT){
//                replaceFragment(new ScientFragment());
//                mCurrentFragment = SCIENT_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.scient_layout_custom);
//            }
//        } else if (id == R.id.nav_dv) {
//            if(mCurrentFragment != QUIZ_FRAGMENT){
//                replaceFragment(new QuizFragment());
//                mCurrentFragment = QUIZ_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.quiz_layout_custom);
//            }
//        } else if (id == R.id.nav_cstc) {
//            if(mCurrentFragment != PET_FRAGMENT){
//                replaceFragment(new PetFragment());
//                mCurrentFragment = PET_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.pet_layout_custom);
//            }
//        } else if (id == R.id.nav_hd) {
//            if(mCurrentFragment != HELP_FRAGMENT){
//                replaceFragment(new HelpFragment());
//                mCurrentFragment = HELP_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.help_layout_custom);
//            }
//        } else if (id == R.id.nav_tg) {
//            if(mCurrentFragment != DIRECTOR_FRAGMENT){
//                replaceFragment(new DirectorFragment());
//                mCurrentFragment = DIRECTOR_FRAGMENT;
//                getSupportActionBar().setCustomView(R.layout.director_layout_custom);
//            }
//        }

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

//    private void replaceFragment(Fragment fragment){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.content_frame, fragment);
//        transaction.commit();
//    }
}

