package com.example.myapplication.Birds;

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

import com.example.myapplication.AmphibiaOrders.Anura.AnuraActivity;
import com.example.myapplication.AnimalClassificationActivity;
import com.example.myapplication.Author.AuthorActivity;
import com.example.myapplication.BirdsOrders.Anseriformes.AnseriformesActivity;
import com.example.myapplication.BirdsOrders.Columbiformes.ColumbiformesActivity;
import com.example.myapplication.BirdsOrders.Falconiformes.FalconiformesActivity;
import com.example.myapplication.BirdsOrders.Galliformes.GalliformesActivity;
import com.example.myapplication.BirdsOrders.Passeriformes.PasseriformesActivity;
import com.example.myapplication.BirdsOrders.Pelecaniformes.PelecaniformesActivity;
import com.example.myapplication.BirdsOrders.Psittaciformes.PsittaciformesActivity;
import com.example.myapplication.BirdsOrders.Strigiformes.StrigiformesActivity;
import com.example.myapplication.Class.ClassActivity;
import com.example.myapplication.Mammals.LearnMammalsFragment;
import com.example.myapplication.Mammals.MammalsActivity;
import com.example.myapplication.MammalsOrders.Artiodactyla.ArtiodactylaActivity;
import com.example.myapplication.MammalsOrders.Carnivora.CarnivoraActivity;
import com.example.myapplication.MammalsOrders.Cetacea.CetaceaActivity;
import com.example.myapplication.MammalsOrders.Chiroptera.ChiropteraActivity;
import com.example.myapplication.MammalsOrders.Insectivora.InsectivoraActivity;
import com.example.myapplication.MammalsOrders.Monotremata.MonotremataActivity;
import com.example.myapplication.MammalsOrders.Primates.PrimatesActivity;
import com.example.myapplication.MammalsOrders.Rodentia.RodentiaActivity;
import com.example.myapplication.Pet.PetActivity;
import com.example.myapplication.Quiz.QuizActivity;
import com.example.myapplication.R;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.r0adkll.slidr.Slidr;

import java.util.List;

public class BirdsActivity extends AppCompatActivity implements BirdsAdapter.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView_class;
    private BirdsAdapter adapter;
    private Button btnNext;
    private List<Birds> itemList;
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
    LearnBirdsFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);

        Slidr.attach(this);

        Intent intent = getIntent();
        int itemId = intent.getIntExtra("idclas", 0);
        String des = intent.getStringExtra("descriptionClass");

        recyclerView_class = findViewById(R.id.rcvBirds);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView_class.setLayoutManager(gridLayoutManager);

        loadData();

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.aves_layout_custom);

        drawerLayout = findViewById(R.id.my_drawer_layoutBirds);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //--------
        NavigationView navigationView = findViewById(R.id.navigation_viewBirds);
        navigationView.setNavigationItemSelectedListener(this);

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new ClassFragment());
        navigationView.getMenu().findItem(R.id.nav_kp).setChecked(true);
        fragmentManager = getSupportFragmentManager();
        fragment = LearnBirdsFragment.newInstance(des);

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
        GetBirdsFromApi getDataTask = new GetBirdsFromApi(data -> {
            itemList = data;
            adapter = new BirdsAdapter(itemList, this);
            recyclerView_class.setAdapter(adapter);
        });
        getDataTask.execute();
    }


    @Override
    public void onItemClick(int itemId, String des) {
        if(itemId == 25){
            Intent intent = new Intent(BirdsActivity.this, PasseriformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (itemId == 27) {
            Intent intent = new Intent(BirdsActivity.this, FalconiformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 28) {
            Intent intent = new Intent(BirdsActivity.this, StrigiformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (itemId == 29) {
            Intent intent = new Intent(BirdsActivity.this, AnseriformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 30) {
            Intent intent = new Intent(BirdsActivity.this, GalliformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 31) {
            Intent intent = new Intent(BirdsActivity.this, PsittaciformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 32) {
            Intent intent = new Intent(BirdsActivity.this, ColumbiformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if (itemId == 33) {
            Intent intent = new Intent(BirdsActivity.this, PelecaniformesActivity.class);
            intent.putExtra("OrdoID", itemId);
            intent.putExtra("DescriptionOrdo", des);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else{
            Toast.makeText(this, "Clicked item ID: " + itemId, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_kp){
            startActivity(new Intent(BirdsActivity.this, ClassActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_dv){
            startActivity(new Intent(BirdsActivity.this, QuizActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }else if(id == R.id.nav_tg){
            startActivity(new Intent(BirdsActivity.this, AuthorActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (id == R.id.nav_cstc) {
            startActivity(new Intent(BirdsActivity.this, PetActivity.class));
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
        Intent intent = new Intent(BirdsActivity.this, AnimalClassificationActivity.class);
        startActivity(intent);   }
}