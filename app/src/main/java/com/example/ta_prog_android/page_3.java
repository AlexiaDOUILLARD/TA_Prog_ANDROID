package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        switch2 = findViewById(R.id.switch2);

        switch2.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                switcher = true;
            }
        });

        // Listener sur les 3 images boutons
        imageButton.setOnClickListener(v -> {
            //change boolean value
            clicked_yes = true;
        });

        imageButton2.setOnClickListener(v -> {
            //change boolean value
            clicked_no = true;
        });

        imageButton3.setOnClickListener(v -> {
            //change boolean value
            clicked_intero = true;
        });

        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromPage2ToPage3");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                String yes = "Oui";
                String non = "Non";
                if (this.person.getDiscussWithDoctor()){
                    editTextTextPersonName2.setText(yes);
                } else if (!this.person.getDiscussWithDoctor()){
                    editTextTextPersonName2.setText(non);
                }
                if (this.person.getCardiacCheckUp()){
                    switch2.setChecked(true);
                }
                if (this.person.getConsultCardiologist().toString().equals("OUI")){
                    imageButton.setSelected(true);
                } else if (this.person.getConsultCardiologist().toString().equals("NON")){
                    imageButton2.setSelected(true);
                } else if (this.person.getConsultCardiologist().toString().equals("NE_SAIT_PAS")){
                    imageButton3.setSelected(true);
                }
            } else {
                Person transferredPerson2 = intent.getParcelableExtra("FromPage4ToPage3");
                if (transferredPerson2 != null) {
                    this.person = transferredPerson2;
                    String yes = "Oui";
                    String non = "Non";
                    if (this.person.getDiscussWithDoctor()){
                        editTextTextPersonName2.setText(yes);
                    } else if (!this.person.getDiscussWithDoctor()){
                        editTextTextPersonName2.setText(non);
                    }
                    if (this.person.getCardiacCheckUp()){
                        switch2.setChecked(true);
                    }
                    if (this.person.getConsultCardiologist().toString().equals("OUI")){
                        imageButton.setSelected(true);
                    } else if (this.person.getConsultCardiologist().toString().equals("NON")){
                        imageButton2.setSelected(true);
                    } else if (this.person.getConsultCardiologist().toString().equals("NE_SAIT_PAS")){
                        imageButton3.setSelected(true);
                    }
                }
            }
        }
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

    public void PreviousPage2(View view){
        Intent intent = new Intent(this, page_2.class);
        processIntentData();
        intent.putExtra("FromPage3ToPage2", this.person);
        startActivity(intent);
    }

    public void NextPageResults(View sender){
        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {
            Intent intent = new Intent(this, page_4.class);
            processIntentData();
            intent.putExtra("FromPage3ToPage4", this.person);
            startActivity(intent);
        }
    }
}