package com.example.myapplication.MammalsOrders.Carnivora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.CarnivoraFamilies.Canidae.CanidaeActivity;
import com.example.myapplication.R;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.List;

public class CarnivoraActivity extends AppCompatActivity implements CarnivoraAdapter.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView_class;
    private CarnivoraAdapter adapter;
    private Button btnNext;
    private List<Carnivora> itemList;

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
        setContentView(R.layout.activity_carnivora);

        Slidr.attach(this);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("OrdoID", 0);

        recyclerView_class = findViewById(R.id.rcvCarnivora);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_class.setLayoutManager(gridLayoutManager);

        loadData();
        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.carnivora_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutCarnivora);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewCarnivora);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);
    }

    private void loadData() {
        GetCarnivoraFromApi getDataTask = new GetCarnivoraFromApi(data -> {
            itemList = data;
            adapter = new CarnivoraAdapter(itemList, this);
            recyclerView_class.setAdapter(adapter);
        });
        getDataTask.execute();
    }

    @Override
    public void onItemClick(int itemId) {
        if(itemId == 1){
            Intent intent = new Intent(CarnivoraActivity.this, CanidaeActivity.class);
            intent.putExtra("FamliyID", itemId);
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
    public void CameraClick(MenuItem item){
        Toast.makeText(this, "Clicked camera!", Toast.LENGTH_SHORT).show();    }
}