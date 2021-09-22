package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "Accueil"; // Identifiant pour les messages de log
    private EditText Pageacceuil_Champsnom; // Boite de saisie du nom

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bouton lancement app
        Button pageacceuil_button_test = findViewById(R.id.Pageacceuil_button_test);

        pageacceuil_button_test.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, page_1.class);
            MainActivity.this.startActivity(intent);
        });
    }
}