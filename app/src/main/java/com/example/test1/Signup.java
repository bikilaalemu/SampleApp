package com.example.test1;

import android.annotation.SuppressLint;
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

public class Signup extends AppCompatActivity implements View.OnClickListener{
 MyDBHelper dbHelper;
 EditText un,ps1,ps2;
 String username,pass1,pass2,password;

    public String getUsername() {
        username=un.getText().toString();
        return username;
    }

    public String getPass1() {
        pass1=ps1.getText().toString();
        return pass1;
    }

    public String getPass2() {
        pass2=ps2.getText().toString();
        return pass2;
    }

    Button save;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbHelper=new MyDBHelper(this);

        un=findViewById(R.id.un);
        ps1=findViewById(R.id.ps1);
        ps2=findViewById(R.id.ps2);
        save=findViewById(R.id.save);

        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
       if(getPass1()==getPass2()){
           password=getPass1();
           boolean res=dbHelper.insert(getUsername(),password);
           if(res){
               Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
           }
           else{
               Toast.makeText(this, "Error during registration", Toast.LENGTH_SHORT).show();
           }
       }
       else{
           Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
       }
    }
}