package com.example.test1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyTelephone extends AppCompatActivity {
   ImageButton call,send;
   EditText phoneno,txtmsg;
   String phone,message;

    public String getPhone() {
        if(phoneno.getText().toString().isEmpty()){
            return null;
        }
        phone = phoneno.getText().toString();
        return phone;
    }

    public String getMessage() {
        if(txtmsg.getText().toString().isEmpty()){
            return null;
        }
        message = txtmsg.getText().toString();
        return message;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makeCall(getPhone());
            }
            if(requestCode == 2){
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    sendSMS(getPhone(),getMessage());
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_telephone);

        call = findViewById(R.id.call);
        send = findViewById(R.id.send);
        phoneno = findViewById(R.id.phoneno);
        txtmsg = findViewById(R.id.txtmsg);

        call.setOnClickListener(new View.OnClickListener() {

            /*
            Declare the permissions you need in your app's manifest file.
            Check if the permissions are already granted using ContextCompat.checkSelfPermission().
            If the permissions are not granted, request them using ActivityCompat.requestPermissions().
            Handle the results of the permission request in onRequestPermissionsResult()
             */
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MyTelephone.this, android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MyTelephone.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MyTelephone.this, android.Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MyTelephone.this, new String[]{android.Manifest.permission.SEND_SMS}, 2);
                }
            }
        });


    }

    public void makeCall(String phone){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        startActivity(intent);
    }

    public void sendSMS(String phone,String mess){
        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(phone,null,mess,null,null);
    }
}