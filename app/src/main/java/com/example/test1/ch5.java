package com.example.test1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class ch5 extends AppCompatActivity {
   ConnectivityManager cmgr;
   NetworkInfo info;
   Button checknet;
   TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch5);

        cmgr= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        checknet=findViewById(R.id.checknet);
        status=findViewById(R.id.status);

        checknet.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                info=cmgr.getActiveNetworkInfo();
                if(info!=null) {
                    status.setText("Net Status :" + info);
                }
            }
        });
    }
}