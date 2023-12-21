package com.example.myapplication.Reptilia;

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

import com.example.myapplication.AnimalClassificationActivity;
import com.example.myapplication.Invertebrata.LearnInvertebrataFragment;
import com.example.myapplication.Mammals.MammalsActivity;
import com.example.myapplication.MammalsOrders.Artiodactyla.ArtiodactylaActivity;
import com.example.myapplication.MammalsOrders.Carnivora.CarnivoraActivity;
import com.example.myapplication.MammalsOrders.Cetacea.CetaceaActivity;
import com.example.myapplication.MammalsOrders.Chiroptera.ChiropteraActivity;
import com.example.myapplication.MammalsOrders.Primates.PrimatesActivity;
import com.example.myapplication.R;
import com.example.myapplication.ReptileOrders.Crocodylia.CrocodyliaActivity;
import com.example.myapplication.ReptileOrders.Lacertilia.LacertiliaActivity;
import com.example.myapplication.ReptileOrders.Rhynchocephalia.RhynchocephaliaActivity;
import com.example.myapplication.ReptileOrders.Serpentes.SerpentesActivity;
import com.example.myapplication.ReptileOrders.Testudines.TestudinesActivity;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.List;

public class ReptiliaActivity extends AppCompatActivity implements ReptiliaAdapter.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView_class;
    private ReptiliaAdapter adapter;
    private Button btnNext;
    private List<Reptilia> itemList;
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
    LearnReptiliaFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reptilia);

        Slidr.attach(this);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("idclas", 0);
        String des = intent.getStringExtra("descriptionClass");

        recyclerView_class = findViewById(R.id.rcvReptilia);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_class.setLayoutManager(gridLayoutManager);

        loadData();

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.reptilia_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutReptilia);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewReptilia);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);
        fragmentManager = getSupportFragmentManager();
        fragment = LearnReptiliaFragment.newInstance(des);
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
        GetReptiliaFromApi getDataTask = new GetReptiliaFromApi(data -> {
            itemList = data;
            adapter = new ReptiliaAdapter(itemList, this);
            recyclerView_class.setAdapter(adapter);
        });
        getDataTask.execute();
    }


    @Override
    public void onItemClick(int itemId, String des) {
        if(itemId == 34){
            Intent intent = new Intent(ReptiliaActivity.this, SerpentesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (itemId == 35) {
            Intent intent = new Intent(ReptiliaActivity.this, TestudinesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 36) {
            Intent intent = new Intent(ReptiliaActivity.this, CrocodyliaActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (itemId == 37) {
            Intent intent = new Intent(ReptiliaActivity.this, RhynchocephaliaActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 38) {
            Intent intent = new Intent(ReptiliaActivity.this, LacertiliaActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            Toast.makeText(this, "Hiện tại chưa có thông tin", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(ReptiliaActivity.this, AnimalClassificationActivity.class);
        startActivity(intent);    }
}