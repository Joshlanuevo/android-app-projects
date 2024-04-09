package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextView textView;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting the user input (Kilos)
                 String inputText = editText.getText().toString();

                // Converting a string into double
                 double kilos = Double.parseDouble(inputText);

                 // Converting kilos into pounds
                double pounds = makeConversion(kilos);

                textView.setText("" + pounds);

                // Hide Keyboard after the conversion
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });
    }

    private double makeConversion(double kilos) {
        // 1 kilo is equivalent to 2.20462

        return kilos * 2.20462;
    }
}