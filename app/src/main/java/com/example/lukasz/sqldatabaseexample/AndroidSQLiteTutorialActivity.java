package com.example.lukasz.sqldatabaseexample;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class AndroidSQLiteTutorialActivity extends Activity {

    EditText name, number;
    String nameString, numberString;
    DatabaseHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        db = new DatabaseHandler(this);
        name = (EditText) findViewById(R.id.editText);
        number = (EditText) findViewById(R.id.editText2);
    }

    public void insertData(View view) {
        nameString = name.getText().toString();
        numberString = number.getText().toString();
        db.addContact(new Contact(nameString, numberString));
    }

    public void readData(View view) {
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}