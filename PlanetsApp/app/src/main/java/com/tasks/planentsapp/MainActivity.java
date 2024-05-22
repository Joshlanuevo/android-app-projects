package com.tasks.planentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 - AdapterView: a ListView
        listView = findViewById(R.id.listView);

        // 2 - Data Source: ArrayList<Planet>
        planetsArrayList = new ArrayList<>();
    }
}