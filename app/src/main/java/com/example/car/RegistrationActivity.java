package com.example.car;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstName,lastname,email,license,phoneNumber,street,city,postalCode,password,confirmPassword;

    private Button register;
    private TextView login;
    private TextView errtxt;

    private TextView expiryDate;
    private TextView dob;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = findViewById(R.id.firstName);
        lastname = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        license = findViewById(R.id.license);
        phoneNumber = findViewById(R.id.phoneNumber);
        street = findViewById(R.id.street);
        city = findViewById(R.id.city);
        postalCode = findViewById(R.id.postalCode);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        errtxt = findViewById(R.id.errtxt);
        mAuth= FirebaseAuth.getInstance();

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
                    password.requestFocus();
                    password.setError("Passwords Don't Match !!");
                    password.setText("");
                    confirmPassword.setText("");

                }
                if(firstName.length()==0 || lastname.length()==0 || password.length()==0 || confirmPassword.length()==0 || email.length()==0) {
                    errtxt.setVisibility(View.VISIBLE);
                    errtxt.setText(" Please Fill Out All the Fields ");
                }
                else {


                    String firstname = firstName.getText().toString();
                    String lastName = lastname.getText().toString();
                    String emailID = email.getText().toString();
                    String license1 = license.getText().toString();
                    String phoneNo = phoneNumber.getText().toString();
                    String Street = street.getText().toString();
                    String cit = city.getText().toString();
                    String postal_Code = postalCode.getText().toString();
                    String passwd = password.getText().toString();
                    String dateofbirth = dob.getText().toString();
                    String expiryD = expiryDate.getText().toString();

                    mAuth.createUserWithEmailAndPassword(emailID,passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){


                            Toast.makeText(RegistrationActivity.this, "Account Created !!", Toast.LENGTH_SHORT).show();
                            FirebaseUser user=mAuth.getCurrentUser();
                            String Uid=user.getUid();

                            rootNode = FirebaseDatabase.getInstance("https://car-97838-default-rtdb.firebaseio.com/");
                            reference = rootNode.getReference("Users");
                            UserHelperClass helperClass = new UserHelperClass(firstname, lastName, emailID, license1, expiryD, dateofbirth, phoneNo, Street, cit, postal_Code, passwd);
                            reference.child(Uid).setValue(helperClass);
                            Intent i=new Intent(RegistrationActivity.this, MainActivity.class);
                            //i.putExtra("name",Username);
                            startActivity(i);
                            finish();
                            }
                        }
                    });
                }

            }
        });

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerPage = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(registerPage);
            }
        });

        expiryDate = findViewById(R.id.expiryDate);

        expiryDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                openCalendar(expiryDate);
            }
        });

        dob = findViewById(R.id.dob);

        dob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                    openCalendar(dob);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void openCalendar(TextView expiryDate) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this);

        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = year + "-" + month + "-" + dayOfMonth;
                expiryDate.setText(date);
            }
        });

        datePickerDialog.show();
    }

}



