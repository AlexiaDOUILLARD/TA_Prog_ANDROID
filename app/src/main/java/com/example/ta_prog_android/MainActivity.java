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
        person = new Person();
        setContentView(R.layout.activity_main);
        Pageacceuil_Champsnom = findViewById(R.id.Pageacceuil_Champsnom);

        // Bouton lancement app
        Button pageacceuil_button_test = findViewById(R.id.Pageacceuil_button_test);

        pageacceuil_button_test.setOnClickListener(v -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                String n = Pageacceuil_Champsnom.getText().toString();
                person.setName(n);
                Intent intent = new Intent(MainActivity.this, page_1.class);
                intent.putExtra("FromAccueilToPage1", this.person);
                MainActivity.this.startActivity(intent);
            }
        });
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