package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class page_3_inter_page_4 extends AppCompatActivity {

    private static final String TAG = "Page_3 Stat :";
    private Person person;
    private EditText taille, poids, sport;
    boolean isAllFieldsChecked = false; // booleen pour vérifier le remplissage des champs

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
                int tail = person.getTaille();
                String tail2 = String.valueOf(tail);
                int poi = person.getPoids();
                String poi2 = String.valueOf(poi);

                if (this.person.getTaille() != 0) {
                    taille.setText(tail2);
                }
                if (this.person.getPoids() != 0) {
                    poids.setText(poi2);
                }
                if (!this.person.getSport().toString().equals("NON_DEFINIS")) {
                    sport.setText(person.getSport().toString());
                }
            } else {
                Person transferredPerson2 = intent.getParcelableExtra("FromPage5ToPage4");
                if (transferredPerson2 != null) {
                    this.person = transferredPerson2;
                    int tail = person.getTaille();
                    String tail2 = String.valueOf(tail);
                    int poi = person.getPoids();
                    String poi2 = String.valueOf(poi);
                    if (this.person.getTaille() != 0) {
                        taille.setText(tail2);
                    }
                    if (this.person.getPoids() != 0) {
                        poids.setText(poi2);
                    }
                    if (!this.person.getSport().toString().equals("NON_DEFINIS")) {
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
        if (taille.getText().toString().contains(".")) {
            taille.setError("Un taille en mètres n'a pas de virgule");
            return false;
        }
        if (Integer.parseInt(taille.getText().toString()) >= 250) {
            taille.setError("La taille est trop grande");
            return false;
        }
        if (poids.getText().toString().isEmpty()) {
            poids.setError("This field is required");
            return false;
        }
        if (poids.getText().toString().contains(".")) {
            poids.setError("Arrondissez votre poids au kilo supérieur");
            return false;
        }
        if (Integer.parseInt(poids.getText().toString()) >= 250) {
            poids.setError("Le poids est trop grand");
            return false;
        }
        if ((sport.length() != 0) && (!verification_texte())) {
            sport.setError("This value is not accepted (help : Oui/oui,Non/non,Yes/yes,No/no");
            return false;
        }
        // after all validation return true.
        return true;
    }

    // fonction qui retourne un booléen permettant de vérifier que le champs texte contient la réponse oui/non et pas autre chose
    private boolean verification_texte() {
        String s = sport.getText().toString();
        List<String> ma_liste = Arrays.asList("Oui", "Non", "oui", "non", "Yes", "No", "yes", "no");
        return ma_liste.contains(s);
    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson3 = intent.getParcelableExtra("FromPage3ToPage4");
            if (transferredPerson3 != null) {
                this.person = transferredPerson3;
                String s = sport.getText().toString();
                String tail = taille.getText().toString();
                String poi = poids.getText().toString();
                int t = Integer.parseInt(tail);
                int p = Integer.parseInt(poi);
                if (s.equals("Oui") || s.equals("oui") || s.equals("Yes") || s.equals("yes")) {
                    this.person.setSport(YES_NO.OUI);
                } else if (s.equals("Non") || s.equals("non") || s.equals("No") || s.equals("no")) {
                    this.person.setSport(YES_NO.NON);
                }
                if (t >= 0) {
                    this.person.setTaille(t);
                }
                if (p >= 0) {
                    this.person.setPoids(p);
                }
                Log.d(TAG, person.toString());
            } else {
                Person transferredPerson4 = intent.getParcelableExtra("FromPage5ToPage4");
                Log.d(TAG, "No Person found after transfer from Page5");
                if (transferredPerson4 != null) {
                    this.person = transferredPerson4;
                    String s = sport.getText().toString();
                    String tail = taille.getText().toString();
                    String poi = poids.getText().toString();
                    int t = Integer.parseInt(tail);
                    int p = Integer.parseInt(poi);
                    if (s.equals("Oui") || s.equals("oui") || s.equals("Yes") || s.equals("yes")) {
                        this.person.setSport(YES_NO.OUI);
                    } else if (s.equals("Non") || s.equals("non") || s.equals("No") || s.equals("no")) {
                        this.person.setSport(YES_NO.NON);
                    }
                    if (t >= 0) {
                        this.person.setTaille(t);
                    }
                    if (p >= 0) {
                        this.person.setPoids(p);
                    }
                    Log.d(TAG, person.toString());
                    Log.d(TAG, "Person found after transfer from Page5 to Page4");

                }
            }
        } else {
            Log.d(TAG, "Error when transferring from Page4");
        }
    }

    public void PreviousPage3(View view) {
        Intent intent = new Intent(this, page_3.class);
        processIntentData();
        intent.putExtra("FromPage4ToPage3", this.person);
        startActivity(intent);
    }

    public void NextPageResults(View sender) {
        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {
            Intent intent = new Intent(this, page_4.class);
            processIntentData();
            intent.putExtra("FromPage4ToPage5", this.person);
            startActivity(intent);
        }
    }
}