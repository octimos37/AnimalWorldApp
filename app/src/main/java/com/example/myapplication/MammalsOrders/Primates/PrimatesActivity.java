package com.example.myapplication.MammalsOrders.Primates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.CarnivoraFamilies.Canidae.CanidaeActivity;
import com.example.myapplication.MammalsOrders.Monotremata.GetMonotremataFromApi;
import com.example.myapplication.MammalsOrders.Monotremata.LearnMonotremataFragment;
import com.example.myapplication.MammalsOrders.Monotremata.Monotremata;
import com.example.myapplication.MammalsOrders.Monotremata.MonotremataActivity;
import com.example.myapplication.MammalsOrders.Monotremata.MonotremataAdapter;
import com.example.myapplication.R;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.List;

public class PrimatesActivity extends AppCompatActivity implements PrimatesAdapter.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView_class;
    private PrimatesAdapter adapter;
    private Button btnNext;
    private List<Primates> itemList;

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
    LearnPrimatesFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primates);

        Slidr.attach(this);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("OrdoID", 0);
        String des = intent.getStringExtra("DescriptionOrdo");

        recyclerView_class = findViewById(R.id.rcvPrimates);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_class.setLayoutManager(gridLayoutManager);

        loadData();
        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.primates_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutPrimates);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewPrimates);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);
        fragmentManager = getSupportFragmentManager();
        fragment = LearnPrimatesFragment.newInstance(des);

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
        GetPrimatesFromApi getDataTask = new GetPrimatesFromApi(data -> {
            itemList = data;
            adapter = new PrimatesAdapter(itemList, this);
            recyclerView_class.setAdapter(adapter);
        });
        getDataTask.execute();
    }

    @Override
    public void onItemClick(int itemId, String des) {
        if(itemId == 1){
            Intent intent = new Intent(PrimatesActivity.this, CanidaeActivity.class);
            intent.putExtra("FamliyID", itemId);
            intent.putExtra("DescriptionFamily", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            Toast.makeText(this, "Clicked item ID: " + itemId, Toast.LENGTH_SHORT).show();
        }
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