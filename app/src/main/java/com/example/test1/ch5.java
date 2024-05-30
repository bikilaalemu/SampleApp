package com.example.test1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
            @Override
            public void onClick(View view) {
                info=cmgr.getActiveNetworkInfo();
                status.setText(info.toString());
            }
        });
    }
}