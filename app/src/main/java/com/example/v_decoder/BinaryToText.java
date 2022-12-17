package com.example.v_decoder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BinaryToText extends Activity {
    public android.widget.EditText EditText;
    public android.widget.TextView TextView;
    public Button ConvertButton;
    public Button CopyButton;
    public Button ClearButton;
    public android.widget.ImageView ImageButton;

    public static String binaryToString(String input) {
        String[] parts = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            int val = Integer.parseInt(part, 2);
            String c = Character.toString((char) val);
            sb.append(c);
        }

        return sb.toString();

    }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_to_text);

        ConvertButton = (Button)findViewById(R.id.convertButton);
        TextView = (TextView)findViewById(R.id.textView5);
        EditText = findViewById(R.id.textWritter);
        CopyButton = (Button)findViewById(R.id.copy2);
        ClearButton = (Button)findViewById(R.id.clear);
        TextView.setMovementMethod(new ScrollingMovementMethod());
        ImageButton = (ImageView) findViewById(R.id.BackButton);


        TextView.setMovementMethod(new ScrollingMovementMethod());

        ImageButton.setColorFilter(getResources().getColor(R.color.background));

        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = EditText.getText().toString();
                TextView.setText(binaryToString(edit));

            }
        });

        CopyButton.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("textCopy", TextView.getText().toString());
            clipboard.setPrimaryClip(clip);
        });

        ClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText.setText(" ");
                TextView.setText(" ");
            }
        });

        ImageButton.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.testanim, R.anim.testanim2);
        });
    }
}