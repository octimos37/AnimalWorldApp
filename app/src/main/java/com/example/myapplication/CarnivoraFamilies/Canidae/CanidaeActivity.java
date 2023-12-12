package com.example.myapplication.CarnivoraFamilies.Canidae;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.MammalsOrders.Carnivora.LearnCarnivoraFragment;
import com.example.myapplication.R;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;
import java.util.List;

public class CanidaeActivity extends AppCompatActivity implements CanidaeRecyclerViewInterface, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;
    private CanidaeAdapter adapter;
    private Button btnLoad;

    private Button btnNext;

    private List<Canidae> itemList;
    private SearchView searchView;

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
    private boolean flag = false;
    FragmentTransaction tran;
    FragmentManager fragmentManager;
    LearnCanidaeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canidae);
        Slidr.attach(this);

        itemList = new ArrayList<>();

        searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setFocusable(false);

        searchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                searchView.setFocusable(true); // Enable focusability of the SearchView
                return false;
            }
        });

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("FamliyID", 0);
        String des = intent.getStringExtra("DescriptionFamily");



        recyclerView = findViewById(R.id.rcvProductCanidae);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        loadData();

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.canidae_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutCanidae);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewCanidae);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);
        fragmentManager = getSupportFragmentManager();
        fragment = LearnCanidaeFragment.newInstance(des);

        LinearLayout learn = findViewById(R.id.lnly_class);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    // Close the fragment
                    closeFragment();
                    animateBack();
                } else {
                    // Open the fragment
                    openFragment();
                    animateGo();
                }
            }
        });
    }


    private void loadData() {
        GetCanidaeFromApi getDataTask = new GetCanidaeFromApi(data -> {
            List<Canidae> listCanidae = data;
            adapter = new CanidaeAdapter(listCanidae, this);
            recyclerView.setAdapter(adapter);
        });
        getDataTask.execute();
    }

    @Override
    public void onItemClick(Canidae canidae) {
        Intent intent = new Intent(CanidaeActivity.this, CanidaeDetailActivity.class);

        intent.putExtra("title", canidae.getTextData());
        intent.putExtra("Speciesimage", canidae.getImage_path());
        intent.putExtra("description", canidae.getDescription());
        intent.putExtra("AnimalVideo", canidae.getAnimalVideo());
        intent.putExtra("iFact", canidae.getiFact());
        intent.putExtra("ReferenceLink", canidae.getInfo());

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
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
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){

    }
    private void openFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frm_list, fragment);
        fragmentTransaction.commit();
        flag = true;
    }

    private void closeFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
        flag = false;
    }
    private void animateGo() {
        ImageView arrow = findViewById(R.id.iv_arrow);
        ObjectAnimator animator = ObjectAnimator.ofFloat(arrow, "rotation", 0f, 90f);
        animator.setDuration(250); // Set the animation duration in milliseconds
        animator.start();
    }
    private void animateBack() {
        ImageView arrow = findViewById(R.id.iv_arrow);
        ObjectAnimator animator = ObjectAnimator.ofFloat(arrow, "rotation", 90f, 0f);
        animator.setDuration(250); // Set the animation duration in milliseconds
        animator.start();
    }
    public void CameraClick(MenuItem item){
        Toast.makeText(this, "Clicked camera!", Toast.LENGTH_SHORT).show();    }
}