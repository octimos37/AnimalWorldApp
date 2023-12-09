package com.example.myapplication.Pet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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

import com.example.myapplication.Amphibia.AmphibiaActivity;
import com.example.myapplication.AnimalClassificationActivity;
import com.example.myapplication.Author.AuthorActivity;
import com.example.myapplication.Birds.BirdsActivity;
import com.example.myapplication.Class.ClassActivity;
import com.example.myapplication.Invertebrata.InvertebartaActivity;
import com.example.myapplication.Mammals.MammalsActivity;
import com.example.myapplication.Pisces.PiscesActivity;
import com.example.myapplication.Quiz.QuizActivity;
import com.example.myapplication.R;
import com.example.myapplication.Reptilia.ReptiliaActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class PetActivity extends AppCompatActivity implements PetAdapter.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView_class;
    private PetAdapter adapter;
    private Button btnLoad;

    private Button btnNext;

    private List<Pet> itemList;

    private SearchView searchView_class;

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        recyclerView_class = findViewById(R.id.rcvClass);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_class.setLayoutManager(gridLayoutManager);

        loadData();

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.pet_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);


    }

    private void loadData() {
        GetPetFromApi getDataTask = new GetPetFromApi(data -> {
            itemList = data;
            adapter = new PetAdapter(itemList, this);
            recyclerView_class.setAdapter(adapter);
        });
        getDataTask.execute();
    }


    @Override
    public void onItemClick(int itemId) {
        if(itemId == 1){
            Intent intent = new Intent(PetActivity.this, MammalsActivity.class);
            intent.putExtra("IdPet", itemId);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        else if(itemId == 2){
            Intent intent = new Intent(PetActivity.this, BirdsActivity.class);
            intent.putExtra("IdPet", itemId);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_kp){
            startActivity(new Intent(PetActivity.this, ClassActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_dv){
            startActivity(new Intent(PetActivity.this, QuizActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_tg){
            startActivity(new Intent(PetActivity.this, AuthorActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
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

    public void CameraClick(MenuItem item){
        Intent intent = new Intent(PetActivity.this, AnimalClassificationActivity.class);
        startActivity(intent);
    }
}