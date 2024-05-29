package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.signin);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.signup);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.signin){
           startActivity(new Intent(getApplicationContext(),Signin.class));
        } else if (view.getId()==R.id.signup) {
            startActivity(new Intent(getApplicationContext(),Signup.class));
        }else {
            Toast.makeText(this, "Welcome to Android", Toast.LENGTH_SHORT).show();
        }

    }
}