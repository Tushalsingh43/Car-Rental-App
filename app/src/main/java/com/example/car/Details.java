package com.example.car;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    //VEHICLE OBJECT

    //VEHICLE TITLE
    TextView vehicleTitle;

    //VEHICLE PRICE
    TextView vehiclePrice1;

    //VEHICLE AVAILABILITY FIELD
    ConstraintLayout available;
    ConstraintLayout notAvailable;

    //GOING BACK BUTTON
    Button back;
    Button book;

    //VEHICLE INFO FIELD
    TextView year1, manufacturer1, model1, mileage1, seats1, type1,title;

    //INSURANCE OPTION
    private RadioGroup insuranceOption;

    private String chosenInsurance = "";
    private RadioButton option_premium;
    private RadioButton option_none;
    private RadioButton option_basic;

    //VEHICLE IMAGE OBJECT
    private ImageView vehicleImage;
    public Uri imageUri;

    DatabaseReference reference;
    FirebaseDatabase rootNode;
    String m,r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        book = findViewById(R.id.book_this_car);
        back = findViewById(R.id.back);
        year1 = findViewById(R.id.year);
        mileage1 = findViewById(R.id.mileage);
        manufacturer1 = findViewById(R.id.manufacturer);
        model1 = findViewById(R.id.model);
        seats1 = findViewById(R.id.seats);
        type1 = findViewById(R.id.type);
        vehiclePrice1 = findViewById(R.id.vehiclePrice);
        title=findViewById(R.id.vehicleTitle);

        //INSURANCE OPTION
        insuranceOption = findViewById(R.id.insuranceOption);

        //Image
        vehicleImage = findViewById(R.id.vehicleImage);

        m=getIntent().getStringExtra("model").toString(); //m has the car name from previous pages

        title.setText(m);

        reference = FirebaseDatabase.getInstance("https://car-97838-default-rtdb.firebaseio.com/").getReference("Car").child(m);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String year = snapshot.child("Year").getValue().toString();
                String mileage = snapshot.child("Mileage").getValue().toString();
                String manufacturer = snapshot.child("Manufacturer").getValue().toString();
                String model = snapshot.child("Model").getValue().toString();
                String seats = snapshot.child("Seats").getValue().toString();
                String type = snapshot.child("Type").getValue().toString();
                String image = snapshot.child("Image").getValue().toString();
                String vehiclePrice = snapshot.child("Price").getValue().toString();
                Picasso.get().load(image).into(vehicleImage);
                year1.setText(year);
                mileage1.setText(mileage);
                manufacturer1.setText(manufacturer);
                model1.setText(model);
                seats1.setText(seats);
                type1.setText(type);
                vehiclePrice1.setText("Rs."+vehiclePrice+"/Day");
                r=snapshot.child("Price").getValue().toString();
                //vehicleImage.setImageURI(Uri.parse(image));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i=chosenInsurance.toString();
                Intent intent = new Intent(Details.this,BookingCar.class);
                intent.putExtra("model",m);
                intent.putExtra("Insurance",i);
                intent.putExtra("Price",r);
                startActivity(intent);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details.this,Sports.class);
                startActivity(intent);
            }
        });

        insuranceOption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton option = findViewById(checkedId);
                chosenInsurance = option.getText().toString().toLowerCase();
            }
        });

    }
}