package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextView textView;
    Button clearBtn;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        clearBtn = findViewById(R.id.clearBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting the user input (Kilos)
                 String inputText = editText.getText().toString();

                 // If the input is empty and non-numeric
                if (inputText.isEmpty() || !inputText.matches("\\d*\\.?\\d+")) {
                    // Display a toast message indicating invalid input
                    Toast.makeText(MainActivity.this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
                    hideKeyboard();
                    return;
                }

                // Converting a string into double
                 double kilos = Double.parseDouble(inputText);

                 // Converting kilos into pounds
                double pounds = makeConversion(kilos);

                textView.setText("" + pounds);

                // Clear editText
                editText.setText("");

                // Hide Keyboard after the conversion
                hideKeyboard();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearOutput();
            }
        });
    }

    private double makeConversion(double kilos) {
        // 1 kilo is equivalent to 2.20462

        return kilos * 2.20462;
    }

    // Hide keyboard function
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void clearOutput() {
        textView.setText("0");
    }
}