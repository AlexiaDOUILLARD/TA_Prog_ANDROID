package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
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

        // Bouton lancement app
        Button pageacceuil_button_test = findViewById(R.id.Pageacceuil_button_test);
        person = getIntent().getParcelableExtra("FromPage1toAcceuil");
        processIntentData();

        pageacceuil_button_test.setOnClickListener(v -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                person = new Person();
                String n = Pageacceuil_Champsnom.getText().toString();
                person.setName(n);
                Intent intent = new Intent(MainActivity.this, page_1.class);
                intent.putExtra("FromAccueilToPage1", this.person);
                MainActivity.this.startActivity(intent);
            }
        });
    }
    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            // intent may store different data. To get the one matching the Person class,
            // we need the key "FromActivity1ToActivity2" which was used for transfer
            // No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromPage1toAcceuil");
            if (transferredPerson != null) {
                transferredPerson.print();
                Pageacceuil_Champsnom.setText(person.getName());
            }
            else {
                Log.d(MainActivity.TAG, "No Person found after transfer from Activity1");
            }
        }
        else {
            Log.d(MainActivity.TAG, "Error when transferring from Activity1");
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