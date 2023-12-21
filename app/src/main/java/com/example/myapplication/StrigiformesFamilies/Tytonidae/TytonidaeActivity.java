package com.example.myapplication.StrigiformesFamilies.Tytonidae;

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

import com.example.myapplication.AnimalClassificationActivity;
import com.example.myapplication.Author.AuthorActivity;
import com.example.myapplication.Class.ClassActivity;
import com.example.myapplication.Pet.PetActivity;
import com.example.myapplication.Quiz.QuizActivity;
import com.example.myapplication.R;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.GetTytonidaeFromApi;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.LearnTytonidaeFragment;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.Tytonidae;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeActivity;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeAdapter;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeDetailActivity;
import com.example.myapplication.StrigiformesFamilies.Tytonidae.TytonidaeRecyclerViewInterface;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;
import java.util.List;

public class TytonidaeActivity extends AppCompatActivity implements TytonidaeRecyclerViewInterface, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;
    private TytonidaeAdapter adapter;
    private Button btnLoad;

    private Button btnNext;

    private List<Tytonidae> itemList;
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
    LearnTytonidaeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tytonidae);
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



        recyclerView = findViewById(R.id.rcvProductTytonidae);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        loadData();

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tytonidae_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutTytonidae);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewTytonidae);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);
        fragmentManager = getSupportFragmentManager();
        fragment = LearnTytonidaeFragment.newInstance(des);

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
        GetTytonidaeFromApi getDataTask = new GetTytonidaeFromApi(data -> {
            List<Tytonidae> listTytonidae = data;
            adapter = new TytonidaeAdapter(listTytonidae, this);
            recyclerView.setAdapter(adapter);
        });
        getDataTask.execute();
    }

    @Override
    public void onItemClick(Tytonidae Tytonidae) {
        Intent intent = new Intent(TytonidaeActivity.this, TytonidaeDetailActivity.class);

        intent.putExtra("title", Tytonidae.getTextData());
        intent.putExtra("Speciesimage", Tytonidae.getImage_path());
        intent.putExtra("description", Tytonidae.getDescription());
        intent.putExtra("AnimalVideo", Tytonidae.getAnimalVideo());
        intent.putExtra("iFact", Tytonidae.getiFact());
        intent.putExtra("ReferenceLink", Tytonidae.getInfo());

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_kp){
            startActivity(new Intent(TytonidaeActivity.this, ClassActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_dv){
            startActivity(new Intent(TytonidaeActivity.this, QuizActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_tg){
            startActivity(new Intent(TytonidaeActivity.this, AuthorActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (id == R.id.nav_cstc) {
            startActivity(new Intent(TytonidaeActivity.this, PetActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }return false;
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
        Intent intent = new Intent(TytonidaeActivity.this, AnimalClassificationActivity.class);
        startActivity(intent);     }
}