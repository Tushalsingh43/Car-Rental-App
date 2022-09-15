package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingComplete extends AppCompatActivity {

    private Button back;

    //DRIVER DETAILS
    private TextView name, email, phoneNumber,pickupTime,pickupDate,returnTime,returnDate,vehiclename,totalcost,rate;

    //BOOKING SUMMARY
    private TextView bookingID, vehicleName, _pickup, _return, insurance, insuranceRate, totalCost,totaldays;

    public String s,e,pr;

    DatabaseReference ref = FirebaseDatabase.getInstance("https://car-97838-default-rtdb.firebaseio.com/").getReference("Bookings");
    //BOOKING
    //private Booking booking;
    //INSURANCE
    //private Insurance chosenInsurance;
    //VEHICLE
    //private Vehicle vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_complete);


        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phoneNumber=findViewById(R.id.phoneNumber);
        insurance=findViewById(R.id.insurance);
        insuranceRate=findViewById(R.id.insuranceRate);
        pickupTime=findViewById(R.id.pickup);
        //pickupDate=findViewById(R.id.pickupDate);
        //returnTime=findViewById(R.id.returnTime);
        returnDate=findViewById(R.id.dropoff);
        vehiclename=findViewById(R.id.vehicleName);
        totalcost=findViewById(R.id.totalCost);
        rate=findViewById(R.id.rate);
        totaldays=findViewById(R.id.totalDays);


        name.setText(getIntent().getStringExtra("Firstname").toString() +" "+getIntent().getStringExtra("lastname"));
        email.setText(getIntent().getStringExtra("email"));
        phoneNumber.setText(getIntent().getStringExtra("phoneNumber"));
        insurance.setText(getIntent().getStringExtra("insurance"));
        pickupTime.setText(getIntent().getStringExtra("pickupDate")+"  "+getIntent().getStringExtra("pickupTime"));
        //pickupDate.setText(getIntent().getStringExtra("pickupDate"));
        //returnTime.setText(getIntent().getStringExtra("returnTime"));
        returnDate.setText(getIntent().getStringExtra("returnDate")+"  "+getIntent().getStringExtra("returnTime"));
        vehiclename.setText(getIntent().getStringExtra("model"));
        totalcost.setText(getIntent().getStringExtra("Price"));
        rate.setText("Rs."+ getIntent().getStringExtra("Price")+"/Day");
        pr=getIntent().getStringExtra("Price");
        totaldays.setText(getIntent().getStringExtra("diff"));

        Long a=new Long(Long.parseLong(pr));
        Long b=new Long(Long.parseLong(getIntent().getStringExtra("diff")));
        Long c=a*b;
        totalcost.setText("Rs."+c.toString());

        String Name=name.getText().toString();
        String Email=email.getText().toString();
        String PhoneNumber=phoneNumber.getText().toString();
        String Insurance=insurance.getText().toString();
        String PickupTime=getIntent().getStringExtra("pickupTime");
        String PickupDate=getIntent().getStringExtra("pickupDate");
        String ReturnDate=getIntent().getStringExtra("returnDate");
        String ReturnTime=getIntent().getStringExtra("returnTime");
        String TotalCost=c.toString();

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser u=auth.getCurrentUser();
        String Uid=u.getUid();

        User user = new User(Name,Email,PhoneNumber,Insurance,PickupDate,ReturnDate,PickupTime,ReturnTime,TotalCost);
        ref.child(Uid).push().setValue(user);

        e = getIntent().getStringExtra("returnDate");
        s = getIntent().getStringExtra("pickupDate");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date str= sdf.parse(e);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }


        // Toast.makeText(this, retDate.toString(), Toast.LENGTH_SHORT).show();
       /* String cos=getIntent().getStringExtra("insurance");
        if (getIntent().getStringExtra("insurance").equals("Basic")){
            insuranceRate.setText("$ 15.0");
        }
        else if(getIntent().getStringExtra("insurance").equals("Premium")){
            insuranceRate.setText("$ 25.0");
        }
        else if(getIntent().getStringExtra("insurance").equals("None")){
            insuranceRate.setText("$ 0.0");
        }*/


    }

}