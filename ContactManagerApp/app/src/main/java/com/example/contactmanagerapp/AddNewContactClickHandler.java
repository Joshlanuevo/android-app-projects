package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel = myViewModel;
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
//            i.putExtra("Name", contact.getName());
//            i.putExtra("Email", contact.getEmail());
            Contacts c = new Contacts(
                    contact.getName(),
                    contact.getEmail()
            );
            myViewModel.addNewContact(c);
            context.startActivity(i);
        }
    }


}
