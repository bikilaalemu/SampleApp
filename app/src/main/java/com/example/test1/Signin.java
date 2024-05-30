package com.example.test1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signin extends AppCompatActivity implements View.OnClickListener{
   Button login;
   EditText usern,userp;
   String username,password;
   MyDBHelper dbHelper;
    public String getUsername() {
        username=usern.getText().toString();
        return username;
    }

    public String getPassword() {
        password=userp.getText().toString();
        return password;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        dbHelper=new MyDBHelper(this);
        usern=findViewById(R.id.usern);
        userp=findViewById(R.id.userp);

        login=findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       /* Cursor cursor=dbHelper.getData();
        if(getUsername()==cursor.getString(0) && getPassword()==cursor.getString(1)){
            Toast.makeText(this, "Welcome "+getUsername(), Toast.LENGTH_SHORT).show();
        }*/
        startActivity(new Intent(getApplicationContext(),ch5.class));
    }
}