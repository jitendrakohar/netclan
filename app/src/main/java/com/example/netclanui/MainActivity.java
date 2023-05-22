package com.example.netclanui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout container;
    private ImageView refine;
    private Fragment selectedFragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set the default fragment to display

        bottomNavigationView = findViewById(R.id.navigation);
        container = findViewById(R.id.container);


        refine=findViewById(R.id.refineimg);

        selectedFragment = new exploreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
//        setNavigationView();
        refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,refineActivity.class));
            }
        });
    }

    public void setNavigationView() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_dashboard:
                        selectedFragment = new exploreFragment();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Don't have any fragment", Toast.LENGTH_SHORT).show();
                        selectedFragment = new exploreFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectedFragment = new exploreFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
    }


}