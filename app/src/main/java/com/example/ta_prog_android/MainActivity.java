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
    private EditText Pageacceuil_Champsnom; // Boite de saisie de la température
    private Button Pageacceuil_button_test; // Bouton radio indiquant si la saisie est en Celsius

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        //Pageacceuil_button_test = findViewById(R.id.Pageacceuil_button_test);

//        Pageacceuil_button_test.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                openNewActivity();
//            }
//        });
    }


//    public void openNewActivity() {
//        Intent intent = new Intent(this, First.class);
//        startActivity(intent);
//    }
}