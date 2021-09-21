package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "UPConvTemp"; // Identifiant pour les messages de log
    private EditText editInputTemp; // Boite de saisie de la température
    private RadioButton rbCelsius; // Bouton radio indiquant si la saisie est en Celsius
    private RadioButton rbFahrenheit; // Bouton radio indiquant si la saisie est en Fahrenheit
    private TextView dispResult; // Le TextView qui affichera le résultat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**setContentView(R.layout.activity_main);**/
        setContentView(R.layout.page1);
        /**setContentView(R.layout.page2);**/
    }
}