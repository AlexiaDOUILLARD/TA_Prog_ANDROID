package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class page_1 extends AppCompatActivity {
    private RadioGroup Group1, groupe_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);

        Button suivant_1 = findViewById(R.id.Suivant_1);
        Button bouton_precedent = findViewById(R.id.bouton_precedent);

        //Bouton pour passer de la page 1 a 2
        suivant_1.setOnClickListener(v -> {
            Intent intent = new Intent(page_1.this, page_2.class);
            page_1.this.startActivity(intent);
        });

        // Permet de passer de la page 1 à la page accueil
        bouton_precedent.setOnClickListener(view -> {
            Intent intent = new Intent(page_1.this, MainActivity.class);
            page_1.this.startActivity(intent);
        });
    }

}