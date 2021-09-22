package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class page_1 extends AppCompatActivity {

    boolean isAllFieldsChecked = false; // booleen pour vérifier le remplissage des champs
    private RadioGroup Group1,Groupe_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);

        Button suivant_1 = findViewById(R.id.Suivant_1);
        Button bouton_precedent = findViewById(R.id.bouton_precedent);
        Group1 = findViewById(R.id.Group1);
        Groupe_age = findViewById(R.id.Groupe_age);


        //Bouton pour passer de la page 1 a 2
        suivant_1.setOnClickListener(v -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                Intent intent = new Intent(page_1.this, page_2.class);
                page_1.this.startActivity(intent);
            }
        });

        // Permet de passer de la page 1 à la page accueil
        bouton_precedent.setOnClickListener(view -> {
            Intent intent = new Intent(page_1.this, MainActivity.class);
            page_1.this.startActivity(intent);
        });

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

}