package com.example.contactmanagerapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Data Source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contacts = new ArrayList<>();

    // Adapter
    private MyAdapter myAdapter;

    // Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handler = new MainActivityClickHandler(this);

        mainBinding.setClickHandler(handler);

        // RecyclerView
        RecyclerView recyclerView = mainBinding.recycleView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Adapter
        myAdapter = new MyAdapter(contacts);

        // Database:
        contactDatabase = ContactDatabase.getInstance(this);

        // ViewModel:
        MyViewModel myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        // Inserting a new Contact (Just For Testing):
        Contacts c1 = new Contacts(1, "Ivan", "Ivan@gmail.com");
        myViewModel.addNewContact(c1);

        // Loading the Data from ROOM DB
        myViewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                for (Contacts c: contacts) {
                    Log.v("Letsgo", c.getName());
                }
            }
        });

        // Linking the RecyclerView with the Adapter
    }
}