package com.example.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Logout extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        bottomNavigationView=findViewById(R.id.bottom_nav1);
        logout=findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Logout.this,MainActivity.class);
                startActivity(i);
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
                        Intent i= new Intent(Logout.this,Dashboard.class);
                        startActivity(i);
                        finish();
                        return true;

                    case R.id.nav_booking:

                        return true;

                    case R.id.nav_account :
                       recreate();
                        return true;
                }

                return false;
            }
        });
    }

}