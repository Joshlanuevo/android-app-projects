package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;

    public AddNewContactClickHandler(Contacts contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    public void onSubmitBtnClicked(View view) {
        String name = contact.getName();
        String email = contact.getEmail();

        if (contact.getName() == null || contact.getName().isEmpty() ||
                contact.getEmail() == null || contact.getEmail().isEmpty()) {
            Toast.makeText(context, "Fields cannot be empty.", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("AddNewContactClickHandler", "Name: " + name);
            Log.d("AddNewContactClickHandler", "Email: " + email);
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("name", contact.getName());
            i.putExtra("email", contact.getEmail());
            context.startActivity(i);
        }
    }


}
