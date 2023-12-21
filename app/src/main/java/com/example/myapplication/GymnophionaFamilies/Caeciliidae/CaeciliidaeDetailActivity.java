package com.example.myapplication.GymnophionaFamilies.Caeciliidae;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.fragment.ClassFragment;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class CaeciliidaeDetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView desTextView;
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
        setContentView(R.layout.activity_caeciliidae_detail);

        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        String textData = getIntent().getStringExtra("title");
        String image_path = getIntent().getStringExtra("Speciesimage");
        String description = getIntent().getStringExtra("description");
        String AnimalVideo = getIntent().getStringExtra("AnimalVideo");
        String iFact = getIntent().getStringExtra("iFact");
        String ReferenceLink = getIntent().getStringExtra("ReferenceLink");

        TextView titleTextView = findViewById(R.id.txt_title);
        desTextView = findViewById(R.id.tv_description);
        ImageView imageView = findViewById(R.id.iv_Caeciliidae);
        ImageView fav = findViewById(R.id.iv_fav);
        ImageView fact = findViewById(R.id.iv_u_know);
        ImageView video = findViewById(R.id.iv_video);
        ImageView info = findViewById(R.id.iv_info);
        ImageView translator = findViewById(R.id.iv_translator);

        translator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ReferenceLink != null && !ReferenceLink.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ReferenceLink));
                    startActivity(intent);
                } else {
                    // Handle the case when the website URL is not provided
                    Toast.makeText(getApplicationContext(), "Website URL is not valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaeciliidaeVideoFragment fragment = CaeciliidaeVideoFragment.newInstance(AnimalVideo);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_image, fragment)
                        .commit();
            }
        });

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaeciliidaeFactFragment fragment = CaeciliidaeFactFragment.newInstance(iFact);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_image, fragment)
                        .commit();
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fav.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.ic_fav1).getConstantState()){
                    fav.setImageResource(R.drawable.ic_fav2);
                }else {
                    fav.setImageResource(R.drawable.ic_fav1);
                }
            }
        });

        titleTextView.setText(textData);
        desTextView.setText(description);
        Picasso.get().load(image_path).into(imageView);

        ImageView imageViewback = findViewById(R.id.iv_back);
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.animal_detail_custom);

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