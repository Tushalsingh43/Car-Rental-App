package com.example.car;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BookingCar extends AppCompatActivity {

    //PICKUP AND RETURN DATE
    private TextView pickupDate, returnDate;

    //PICKUP AND RETURN TIME
    private TextView pickupTime, returnTime;

    //PICKUP DATE/TIME
    private Calendar _pickup;

    //RETURN DATE/TIME
    private Calendar _return;

    //DRIVER DETAILS
    private EditText firstName, lastName, email, phoneNumber;
    private RadioGroup customerTitle;

    //BY DEFAULT TITLE SELECTION
    String mrMs = "mr",m,r;
    //DATE FORMAT -> FOR DISPLAY PURPOSE
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM, d yyyy", Locale.CANADA);
    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.CANADA);

    //DATE/TIME STORING
    //GOING BACK BUTTON and CONTINUE BOOKING BUTTON
    private Button back, continueBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_car);

        //BACK BUTTON
        back = findViewById(R.id.back);
        //CONTINUE BOOKING
        continueBooking = findViewById(R.id.continueBooking);

        //CAR RENTAL DATE AND TIME
        pickupDate = findViewById(R.id.pickupDate);
        pickupTime = findViewById(R.id.pickupTime);

        returnDate = findViewById(R.id.returnDate);
        returnTime = findViewById(R.id.returnTime);

        //DRIVER DETAILS
        customerTitle = findViewById(R.id.mrMsTitle);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);

        //PICKUP AND RETURN DATE OBJECT
        _pickup = Calendar.getInstance();
        _return = Calendar.getInstance();


        //SET THE DATE AND TIME TO CURRENT
        pickupDate.setText(dateFormat.format(_pickup.getTime()));
        pickupTime.setText(timeFormat.format(_pickup.getTime()));

        returnDate.setText(dateFormat.format(_return.getTime()));
        returnTime.setText(timeFormat.format(_return.getTime()));
        m=getIntent().getStringExtra("model").toString(); //m has the car name from previous pages
        r=getIntent().getStringExtra("Price").toString();

        pickupDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                openCalendar(pickupDate);
            }
        });
        returnDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                openCalendar(returnDate);
            }
        });
        pickupTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BookingCar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        pickupTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Pickup Time");
                mTimePicker.show();
            }
        });

        returnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(BookingCar.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        returnTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Return Time");
                mTimePicker.show();
            }
        });

        continueBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n=firstName.getText().toString();
                String l=lastName.getText().toString();
                String e=email.getText().toString();
                String p=phoneNumber.getText().toString();
                String pt=pickupTime.getText().toString();
                String pd=pickupDate.getText().toString();
                String rt=returnTime.getText().toString();
                String rd=returnDate.getText().toString();
                String ins=getIntent().getStringExtra("Insurance").toString();
                Long diff=null;
                Date pd1= null,pd2=null;
                try {
                    pd1 = new SimpleDateFormat("yyyy-MM-dd").parse(pickupDate.getText().toString());
                    pd2=new SimpleDateFormat("yyyy-MM-dd").parse(returnDate.getText().toString());

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    diff= ChronoUnit.DAYS.between(pd1.toInstant(), pd2.toInstant());

                }
                String d = diff.toString();
                Intent intent = new Intent(BookingCar.this,BookingComplete.class);
                intent.putExtra("Firstname",n);
                intent.putExtra("lastname",l);
                intent.putExtra("email",e);
                intent.putExtra("phoneNumber",p);
                intent.putExtra("insurance",ins);
                intent.putExtra("pickupTime",pt);
                intent.putExtra("pickupDate",pd);
                intent.putExtra("returnTime",rt);
                intent.putExtra("returnDate",rd);
                intent.putExtra("model",m);
                intent.putExtra("Price",r);
                intent.putExtra("diff",d);


                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void openCalendar(TextView pickupDate) {

            DatePickerDialog datePickerDialog = new DatePickerDialog(this);

            datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String date = year + "-" + month + "-" + dayOfMonth;
                    pickupDate.setText(date);
                }
            });

            datePickerDialog.show();
    }
}