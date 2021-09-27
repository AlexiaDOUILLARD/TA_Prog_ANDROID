package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Person person;
    public static String TAG = "Accueil"; // Identifiant pour les messages de log
    private EditText Pageacceuil_Champsnom; // Boite de saisie du nom
    boolean isAllFieldsChecked = false; // booleen pour vérifier le remplissage des champs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pageacceuil_Champsnom = findViewById(R.id.Pageacceuil_Champsnom);

        Intent intent = getIntent();
        if (intent!=null){
            Person transferredPerson = intent.getParcelableExtra("FromPage1ToPage0");
            if (transferredPerson !=null) {
                this.person = transferredPerson;
                if (!this.person.getName().isEmpty()) {
                Pageacceuil_Champsnom.setText(this.person.getName());}

            }
            else {
                Log.d(TAG, "No Person found after transfer from Page1");
            }
            Log.d(TAG, "Error when transferring from Page1");
        }
    }

    private void processIntentData (){
        Intent intent = getIntent();
        if (intent!=null){
            Person transferredPerson = intent.getParcelableExtra("FromPage1ToPage0");
            if (transferredPerson !=null){
                this.person = transferredPerson;
                String n = Pageacceuil_Champsnom.getText().toString();
                person.setName(n);
                Log.d(TAG, person.toString());
            }
            else {
                Log.d(TAG, "No Person found after transfer from Page1");
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Page1");
        }
    }

    public void NextPage(View sender){
        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {
            person = new Person();
            String n = Pageacceuil_Champsnom.getText().toString();
            person.setName(n);
            Intent intent = new Intent(this, page_1.class);
            processIntentData();
            intent.putExtra("FromPage0ToPage1", this.person);
            startActivity(intent);
        }
    }

    private boolean CheckAllFields() {
        if (Pageacceuil_Champsnom.length() == 0) {
            Pageacceuil_Champsnom.setError("This field is required");
            return false;
        }
        // after all validation return true.
        return true;
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause :" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart :" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy :" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume :" );
    }
}