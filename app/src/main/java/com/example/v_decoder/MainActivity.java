package com.example.v_decoder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    public Button To_Bin;
    public Button To_Txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        To_Bin = (Button)findViewById(R.id.To_Bin);
        To_Txt = (Button)findViewById(R.id.To_Txt);

        To_Bin.setOnClickListener(v -> {
            Intent i = new Intent(this, TextToBinary.class);
            startActivity(i);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);
        });

        To_Txt.setOnClickListener(v -> {
            Intent i = new Intent(this, BinaryToText.class);
            startActivity(i);
            overridePendingTransition(R.anim.slidein, R.anim.slideout);
        });
    }
}

// @haltenny is here now!