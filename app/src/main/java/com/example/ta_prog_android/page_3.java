package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class page_3 extends AppCompatActivity {

    private static final String TAG = "Page_3 Stat :";
    private Person person;
    private EditText editTextTextPersonName2; // champs texte
    private ImageButton imageButton, imageButton2, imageButton3; // boutons des images
    private Button button3; // bouton page suivante
    private Button buttonpage3prec; // bouton page précédente
    boolean isAllFieldsChecked = false; // booleen pour vérifier le remplissage des champs
    boolean clicked_yes = false; // booléen pour l'image bouton Yes
    boolean clicked_no = false; // booléen pour l'image bouton Non
    boolean clicked_intero = false; // // booléen pour l'image bouton Je sais pas
    private Switch switch2;
    boolean switcher = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        buttonpage3prec = findViewById(R.id.buttonpage3prec);
        button3 = findViewById(R.id.button3);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        switch2 = findViewById(R.id.switch2);

        person = getIntent().getParcelableExtra("FromPage2ToPage3");
        processIntentData();

        // Pour de passer de la page 3 à la page 2
        buttonpage3prec.setOnClickListener(view -> {
            Intent intent = new Intent(page_3.this, page_2.class);
            page_3.this.startActivity(intent);
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    switcher = true;
                }
            }
        });

        // Pour de passer de la page 3 à la page 4
        button3.setOnClickListener(view -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                String s = editTextTextPersonName2.getText().toString();
                if (s.equals("Oui") || s.equals("oui") || s.equals("Yes") || s.equals("yes")){
                    person.setImc(YES_NO.values()[0]);
                }
                if (s.equals("Non") || s.equals("non") || s.equals("No") || s.equals("no")){
                    person.setImc(YES_NO.values()[1]);
                }
                if (switcher) {
                    person.setCardiacCheckUp(true);
                }
                if (clicked_yes){
                    person.setConsultCardiologist(YES_NO.values()[0]);
                }
                if (clicked_no){
                    person.setConsultCardiologist(YES_NO.values()[1]);
                }
                if (clicked_intero){
                    person.setConsultCardiologist(YES_NO.values()[2]);
                }
                Intent intent = new Intent(page_3.this, page_4.class);
                intent.putExtra("FromPage3ToResults", this.person);
                page_3.this.startActivity(intent);
            }
        });

        // Listener sur les 3 images boutons
        imageButton.setOnClickListener(v -> {
            //change boolean value
            clicked_yes=true;
        });

        imageButton2.setOnClickListener(v -> {
            //change boolean value
            clicked_no=true;
        });

        imageButton3.setOnClickListener(v -> {
            //change boolean value
            clicked_intero=true;
        });
    }

    // fonction qui retourne un booléan permettant de vérifier que chacun des champs de la page sont remplis / checked
    private boolean CheckAllFields() {
        if (editTextTextPersonName2.length() == 0) {
            editTextTextPersonName2.setError("This field is required");
            return false;
        }
        if((editTextTextPersonName2.length() != 0) && (!verification_texte()) ){
            editTextTextPersonName2.setError("This value is not accepted (help : Oui/oui,Non/non,Yes/yes,No/no");
            return false;
        }

        if ((!clicked_yes) && (!clicked_no) && (!clicked_intero)   ) {
            Toast.makeText(page_3.this, "Please answer the last question by choosing a button", Toast.LENGTH_LONG).show();
            return false;
        }
        // after all validation return true.
        return true;
    }

    // fonction qui retourne un booléen permettant de vérifier que le champs texte contient la réponse oui/non et pas autre chose
    private boolean verification_texte (){
        String s = editTextTextPersonName2.getText().toString();
        List<String> ma_liste = Arrays.asList("Oui", "Non", "oui","non","Yes","No","yes","no");
        return ma_liste.contains(s);
    }
    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            // intent may store different data. To get the one matching the Person class,
            // we need the key "FromActivity1ToActivity2" which was used for transfer
            // No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromPage2ToPage3");
            if (transferredPerson != null) {
                transferredPerson.print();
            }
            else {
                Log.d(page_3.TAG, "No Person found after transfer from Activity1");
            }
        }
        else {
            Log.d(page_3.TAG, "Error when transferring from Activity1");
        }
    }
}