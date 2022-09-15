package com.example.car;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {

    private TextView register;
    private TextView forgotPass;
    private Button login;
    private EditText email;
    private EditText password;

    //Button
    private Button customer;
    private Button vehicleCategory;
    private Button vehicle;
    private Button populate;

    //Database
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Register
        register = findViewById(R.id.register);

        //Login Button
        login = findViewById(R.id.login);

        //Forgot Password Button
        forgotPass = findViewById(R.id.forgot_password);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        customer = findViewById(R.id.customer);
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerPage = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(registerPage);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.length()==0){
                    if(password.length()==0){
                        email.requestFocus();
                        email.setError("Please Enter an Email");
                        email.requestFocus();
                        email.setError("Please Enter Password");
                    }
                    else {
                        email.requestFocus();
                        email.setError("Please Enter a Username");
                    }
                }
                else if (password.length()==0){
                    password.requestFocus();
                    password.setError("Please Enter Password");
                }
                else{
                    //String n= uname.getText().toString();
                    isUser();
                }

            }
        });
    }

    private void isUser() {

        String enteredUsername = email.getText().toString().trim();
        String enteredPassword = password.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(enteredUsername,enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    FirebaseUser user=mAuth.getCurrentUser();
                    startActivity(new Intent(MainActivity.this,Dashboard.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed!!,Please Register Your Account", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
