package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class page_4 extends AppCompatActivity {

    private Person person;
    private static final String TAG = "Page_4 Stat :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        person = getIntent().getParcelableExtra("FromPage3ToResults");
        processIntentData();

    }

    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            // intent may store different data. To get the one matching the Person class,
            // we need the key "FromActivity1ToActivity2" which was used for transfer
            // No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromPage3ToResults");
            if (transferredPerson != null) {
                transferredPerson.print();
            }
            else {
                Log.d(page_4.TAG, "No Person found after transfer from Activity1");
            }
        }
        else {
            Log.d(page_4.TAG, "Error when transferring from Activity1");
        }
    }


}