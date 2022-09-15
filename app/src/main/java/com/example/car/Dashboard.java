package com.example.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    ImageView imageView,imageView1,imageView2,imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        //Sports
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Sports.class);
                startActivity(intent);
            }
        });

        //SUV
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, SUV.class);
                startActivity(intent);
            }
        });

        //Crossover
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Crossover.class);
                startActivity(intent);
            }
        });

        //Sedan
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Sedan.class);
                startActivity(intent);
            }
        });
clickListener();

    }
    private void clickListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_vehicle:
                        recreate();
                        return true;

                    case R.id.nav_booking:

                        return true;

                    case R.id.nav_account :
                        Intent i= new Intent(Dashboard.this,Logout.class);
                        startActivity(i);
                        finish();
                        return true;
                }

                return false;
            }
        });
    }
}