package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class page_3_inter_page_4 extends AppCompatActivity {

    private static final String TAG = "Page_3 Stat :";
    private Person person;
    private EditText taille, poids, sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_inter_page_4);
        taille = findViewById(R.id.taille);
        poids = findViewById(R.id.poids);
        sport = findViewById(R.id.sport);

        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromPage3ToPage4");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                if (this.person.getTaille() !=0){
                    taille.setText(person.getTaille());
                }
                if (this.person.getPoids() != 0){
                    poids.setText(person.getPoids());
                }
                if (!this.person.getSport().toString().equals("NON_DEFINIS")){
                    sport.setText(person.getSport().toString());
                }
            } else {
                Person transferredPerson2 = intent.getParcelableExtra("FromPage5ToPage4");
                if (transferredPerson2 != null) {
                    this.person = transferredPerson2;
                    if (this.person.getTaille() !=0){
                        taille.setText(person.getTaille());
                    }
                    if (this.person.getPoids() != 0){
                        poids.setText(person.getPoids());
                    }
                    if (!this.person.getSport().toString().equals("NON_DEFINIS")){
                        sport.setText(person.getSport().toString());
                    }
                }
            }
        }
    }

    // fonction qui retourne un booléan permettant de vérifier que chacun des champs de la page sont remplis / checked
    private boolean CheckAllFields() {
        if (taille.getText().toString().isEmpty()) {
            taille.setError("This field is required");
            return false;
        }
        if(taille.getText().toString().contains(".")) {
            taille.setError("Un taille en mètres n'a pas de virgule");
            return false;
        }
        if (Integer.parseInt(taille.getText().toString())>= 250) {
            taille.setError("La taille est trop grande");
            return false;
        }
        if (poids.getText().toString().isEmpty()) {
            poids.setError("This field is required");
            return false;
        }
        if(poids.getText().toString().contains(".")) {
            poids.setError("Arrondissez votre poids au kilo supérieur");
            return false;
        }
        if (Integer.parseInt(poids.getText().toString())>= 250) {
            poids.setError("Le poids est trop grand");
            return false;
        }
        // after all validation return true.
        return true;
    }

    // fonction qui retourne un booléen permettant de vérifier que le champs texte contient la réponse oui/non et pas autre chose
    private boolean verification_texte (){
        String s = sport.getText().toString();
        List<String> ma_liste = Arrays.asList("Oui", "Non", "oui","non","Yes","No","yes","no");
        return ma_liste.contains(s);
    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson3 = intent.getParcelableExtra("FromPage2ToPage3");
            if (transferredPerson3 !=null){
                this.person = transferredPerson3;
                String s = editTextTextPersonName2.getText().toString();
                if (s.equals("Oui") ||s.equals("oui") ||s.equals("Yes")|| s.equals("yes")){
                    this.person.setDiscussWithDoctor(true);
                }
                else if (switcher){
                    this.person.setCardiacCheckUp(true);
                }
                if (clicked_yes){
                    this.person.setConsultCardiologist(YES_NO.OUI);
                } else if (clicked_no){
                    this.person.setConsultCardiologist(YES_NO.NON);
                }else if (clicked_intero){
                    this.person.setConsultCardiologist(YES_NO.NE_SAIT_PAS);
                }
                Log.d(TAG, person.toString());
            }
            else {
                Person transferredPerson4 = intent.getParcelableExtra("FromPage4ToPage3");
                Log.d(TAG, "No Person found after transfer from Page3");
                if (transferredPerson4 !=null){
                    this.person = transferredPerson4;
                    String s = editTextTextPersonName2.getText().toString();
                    if (s.equals("Oui") ||s.equals("oui") ||s.equals("Yes")|| s.equals("yes")){
                        this.person.setDiscussWithDoctor(true);
                    }
                    else if (switcher){
                        this.person.setCardiacCheckUp(true);
                    }
                    if (clicked_yes){
                        this.person.setConsultCardiologist(YES_NO.OUI);
                    } else if (clicked_no){
                        this.person.setConsultCardiologist(YES_NO.NON);
                    }else if (clicked_intero){
                        this.person.setConsultCardiologist(YES_NO.NE_SAIT_PAS);
                    }
                    Log.d(TAG, person.toString());
                    Log.d(TAG, "Person found after transfer from Page4 to Page3");

                }
            }
        }
        else {
            Log.d(TAG, "Error when transferring from Page3");
        }
    }
}