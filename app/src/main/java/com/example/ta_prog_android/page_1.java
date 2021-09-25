package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class page_1 extends AppCompatActivity {

    private Person person;
    private static final String TAG = "Page_1 Stat :";
    boolean isAllFieldsChecked = false; // booleen pour vérifier le remplissage des champs
    private RadioGroup Group1,Groupe_age;
    private RadioButton sexe_homme, sexe_femme,moins_40,entre_40_60,Plus_60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);

        Button suivant_1 = findViewById(R.id.Suivant_1);
        Button bouton_precedent = findViewById(R.id.bouton_precedent);
        Group1 = findViewById(R.id.Group1);
        Groupe_age = findViewById(R.id.Groupe_age);

        person = getIntent().getParcelableExtra("FromAccueilToPage1");
        processIntentData();

        //Bouton pour passer de la page 1 a 2
        suivant_1.setOnClickListener(v -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                int sex = Group1.getCheckedRadioButtonId();
                int age = Groupe_age.getCheckedRadioButtonId();
                if (sex == R.id.sexe_homme) {
                    person.setGenre(Genre.values()[0]);
                }
                if (sex == R.id.sexe_femme) {
                    person.setGenre(Genre.values()[1]);
                }
                if (age == R.id.moins_40) {
                    person.setAge(Age.values()[0]);
                }
                if (age == R.id.entre_40_60) {
                    person.setAge(Age.values()[1]);
                }
                if (age == R.id.Plus_60) {
                    person.setAge(Age.values()[2]);
                }

                Intent intent = new Intent(page_1.this, page_2.class);
                intent.putExtra("FromPage1ToPage2", this.person);
                page_1.this.startActivity(intent);
            }
        });

        // Permet de passer de la page 1 à la page accueil
        bouton_precedent.setOnClickListener(view -> {
            Intent intent = new Intent(page_1.this, MainActivity.class);
            intent.putExtra("FromPage1toAcceuil",this.person);
            page_1.this.startActivity(intent);
        });

    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
        // intent may store different data. To get the one matching the Person class,
        // we need the key "FromActivity1ToActivity2" which was used for transfer
        // No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromAccueilToPage1");
            if (transferredPerson != null) {
                    transferredPerson.print();
            }
            else {
                Log.d(page_1.TAG, "No Person found after transfer from Activity1");
            }
        }
        else {
            Log.d(page_1.TAG, "Error when transferring from Activity1");
        }
    }


    private boolean CheckAllFields() {
        if (Group1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(page_1.this, "please answer this question by clicking a button", Toast.LENGTH_LONG).show();
            return false;
        }
        if (Groupe_age.getCheckedRadioButtonId() == -1) {
            Toast.makeText(page_1.this, "please answer this question by clicking a button", Toast.LENGTH_LONG).show();
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