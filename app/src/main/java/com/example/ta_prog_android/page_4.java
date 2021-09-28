package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class page_4 extends AppCompatActivity {

    private Person person;
    private static final String TAG = "Page_4 Stat :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromPage3ToPage4");
            if (transferredPerson != null) {
                this.person = transferredPerson;

            } else {
                Log.d(TAG, "No Person found after transfer from Page3");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Page3");
        }


    }

    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson3 = intent.getParcelableExtra("FromPage3ToPage4");
            if (transferredPerson3 !=null){
                this.person = transferredPerson3;
                Log.d(TAG, person.toString());
            }
            else {
                Log.d(page_4.TAG, "No Person found after transfer from Page 5 to Page4");
            }
        }
        else {
            Log.d(page_4.TAG, "Error when transferring from Page4");
        }
    }

    public void PreviousPage3(View view){
        Intent intent = new Intent(this, page_3.class);
        processIntentData();
        intent.putExtra("FromPage4ToPage3", this.person);
        startActivity(intent);
    }


}