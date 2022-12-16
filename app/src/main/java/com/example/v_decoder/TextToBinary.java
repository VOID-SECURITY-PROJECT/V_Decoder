package com.example.v_decoder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextToBinary extends Activity {
    public EditText EditText;
    public TextView TextView;
    public Button ConvertButton;
    public Button CopyButton;
    public Button clearButton;

    public static String stringToBinary(String s) {

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            answer.append(Integer.toBinaryString(c)).append(' ');
        }

        return answer.toString();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_binary);

        ConvertButton = (Button)findViewById(R.id.ConvertButton);
        TextView = (TextView)findViewById(R.id.textView3);
        EditText = findViewById(R.id.EditText);
        CopyButton = (Button)findViewById(R.id.copy);
        clearButton = (Button)findViewById(R.id.clear2);
        TextView.setMovementMethod(new ScrollingMovementMethod());//позволяет листать текст

        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = EditText.getText().toString();
                TextView.setText(stringToBinary(edit));
                String txt = TextView.getText().toString();
            }
        });


        CopyButton.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("textCopy", TextView.getText().toString());
            clipboard.setPrimaryClip(clip);
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText.setText(" ");
                TextView.setText(" ");
            }
        });

    }
}

