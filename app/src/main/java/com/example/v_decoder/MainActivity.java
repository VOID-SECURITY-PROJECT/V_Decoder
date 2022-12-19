package com.example.v_decoder;

import androidx.appcompat.app.AppCompatActivity; //
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public Button To_Bin;
    public Button To_Txt;
    public ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        To_Bin = (Button)findViewById(R.id.To_Bin);
        To_Txt = (Button)findViewById(R.id.To_Txt);
        image = (ImageView) findViewById(R.id.imageView);
        Intent i = new Intent(this, TextToBinary.class);
        Intent j = new Intent(this, BinaryToText.class);
        Intent s = new Intent(this, secret.class);


        To_Bin.setOnClickListener(v -> {
            startActivity(i);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);

        });

        To_Txt.setOnClickListener(v -> {
            startActivity(j);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);

        });

        image.setOnClickListener(v -> {
            startActivity(s);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);

        });

    }
}

// @haltenny is here now!