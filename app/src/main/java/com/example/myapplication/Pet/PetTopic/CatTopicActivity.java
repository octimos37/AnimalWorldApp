package com.example.myapplication.Pet.PetTopic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.AnimalClassificationActivity;
import com.example.myapplication.Author.AuthorActivity;
import com.example.myapplication.Class.ClassActivity;
import com.example.myapplication.Quiz.QuizActivity;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.List;

public class CatTopicActivity extends AppCompatActivity implements CatTopicRecyclerViewInterface, NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView_class;
    private CatTopicAdapter adapter;
    private Button btnLoad;

    private Button btnNext;

    private List<CatTopic> itemList;

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

    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_topic);
        Slidr.attach(this);

        recyclerView_class = findViewById(R.id.rcvProductCatTopic);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView_class.setLayoutManager(linearLayoutManager);

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

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView_class.addItemDecoration(itemDecoration);


        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.cat_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutCatTopic);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewCatTopic);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.getMenu().findItem(R.id.nav_cstc).setChecked(true);

        loadData();
    }

    private void loadData() {
        GetCatTopicFromApi getDataTask = new GetCatTopicFromApi(data -> {
            List<CatTopic> listCat = data;
            adapter = new CatTopicAdapter(listCat, this);
            recyclerView_class.setAdapter(adapter);
        });
        getDataTask.execute();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_kp){
            startActivity(new Intent(CatTopicActivity.this, ClassActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_dv){
            startActivity(new Intent(CatTopicActivity.this, QuizActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_tg){
            startActivity(new Intent(CatTopicActivity.this, AuthorActivity.class));
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
        Intent intent = new Intent(CatTopicActivity.this, AnimalClassificationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(CatTopic catTopic) {
        Intent intent = new Intent(CatTopicActivity.this, CatTopicDetailActivity.class);

        intent.putExtra("NamePetDetailTV", catTopic.getTitle());
        intent.putExtra("ImagePetDetail", catTopic.getImage());
        intent.putExtra("PetDetailDes", catTopic.getDescription());

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}