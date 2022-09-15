package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sedan extends AppCompatActivity {

    TextView s1,s2,s3,s4,s5,s6;
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedan);

        s1=findViewById(R.id.se1);
        s2=findViewById(R.id.se2);
        s3=findViewById(R.id.se3);
        s4=findViewById(R.id.se4);
        s5=findViewById(R.id.se5);
        s6=findViewById(R.id.se6);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sedan.this,Details.class);
                intent.putExtra("model",s1.getText().toString());
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sedan.this,Details.class);
                intent.putExtra("model",s2.getText().toString());
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sedan.this,Details.class);
                intent.putExtra("model",s3.getText().toString());
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sedan.this,Details.class);
                intent.putExtra("model",s4.getText().toString());
                startActivity(intent);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sedan.this,Details.class);
                intent.putExtra("model",s5.getText().toString());
                startActivity(intent);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sedan.this,Details.class);
                intent.putExtra("model",s6.getText().toString());
                startActivity(intent);
            }
        });
    }
}