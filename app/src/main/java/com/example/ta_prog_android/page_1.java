package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        Group1 = findViewById(R.id.Group1);
        Groupe_age = findViewById(R.id.Groupe_age);
        sexe_homme = findViewById(R.id.sexe_homme);
        sexe_femme = findViewById(R.id.sexe_femme);
        moins_40 = findViewById(R.id.moins_40);
        entre_40_60 = findViewById(R.id.entre_40_60);
        Plus_60 = findViewById(R.id.Plus_60);

        Intent intent = getIntent();

        if (intent!=null){
            Person transferredPerson = intent.getParcelableExtra("FromPage0ToPage1");
            if (transferredPerson !=null) {
                this.person = transferredPerson;
                if (!this.person.getGenre().toString().equals("NON_DEFINIS")){
                    if (this.person.getGenre().toString().equals("HOMME")){
                        sexe_homme.setChecked(true);
                    }
                    else if (this.person.getGenre().toString().equals("FEMME")){
                        sexe_femme.setChecked(true);
                    }
                    else Log.d(TAG, "aucun sexe attribué");
                }
                if (this.person.getAge().toString().equals("MOINS_40_ANS")){
                    moins_40.setChecked(true);
                }
                else if (this.person.getAge().toString().equals("ENTRE_40_60_ANS")){
                    entre_40_60.setChecked(true);
                }
                else if (this.person.getAge().toString().equals("PLUS_60_ANS")){
                    Plus_60.setChecked(true);
                }

            }
            else {
                Person transferredPerson2 = intent.getParcelableExtra("FromPage2ToPage1");
                if (transferredPerson2 !=null) {
                    this.person = transferredPerson2;
                    if (!this.person.getGenre().toString().equals("NON_DEFINIS")){
                        if (this.person.getGenre().toString().equals("HOMME")){
                            sexe_homme.setChecked(true);
                        }
                        else if (this.person.getGenre().toString().equals("FEMME")){
                            sexe_femme.setChecked(true);
                        }
                        else Log.d(TAG, "aucun sexe attribué");
                    }
                    if (this.person.getAge().toString().equals("MOINS_40_ANS")){
                        moins_40.setChecked(true);
                    }
                    else if (this.person.getAge().toString().equals("ENTRE_40_60_ANS")){
                        entre_40_60.setChecked(true);
                    }
                    else if (this.person.getAge().toString().equals("PLUS_60_ANS")){
                        Plus_60.setChecked(true);
                    }
                }
            }
        }

    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if(intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromPage0ToPage1");
            if (transferredPerson !=null){
                this.person = transferredPerson;
                if (sexe_homme.isChecked()){person.setGenre(Genre.HOMME);}
                else if (sexe_femme.isChecked()){person.setGenre(Genre.FEMME);}
                if (moins_40.isChecked()){person.setAge(Age.MOINS_40_ANS);}
                else if (entre_40_60.isChecked()){person.setAge(Age.ENTRE_40_60_ANS);}
                else if (Plus_60.isChecked()){person.setAge(Age.PLUS_60_ANS);}
                Log.d(TAG, person.toString());
            }
            else {
                Person transferredPerson2 = intent.getParcelableExtra("FromPage2ToPage1");
                Log.d(TAG, "No Person found after transfer from Page1");
                if (transferredPerson2 !=null){
                    this.person = transferredPerson2;
                    if (sexe_homme.isChecked()) {person.setGenre(Genre.HOMME);}
                    else if (sexe_femme.isChecked()){person.setGenre(Genre.FEMME);}
                    if (moins_40.isChecked()){person.setAge(Age.MOINS_40_ANS);}
                    else if (entre_40_60.isChecked()){person.setAge(Age.ENTRE_40_60_ANS);}
                    else if (Plus_60.isChecked()){person.setAge(Age.PLUS_60_ANS);}
                    Log.d(TAG, person.toString());
                    Log.d(TAG, " Person found after transfer from Activity3 to 2");
                }
            }
        }
        else {
            Log.d(page_1.TAG, "Error when transferring from Page1");
        }
    }

    public void PreviousPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        processIntentData();
        intent.putExtra("FromPage1ToPage0", this.person);
        startActivity(intent);
    }

    public void NextToPage2(View sender){
        isAllFieldsChecked = CheckAllFields();
        if (isAllFieldsChecked) {
        Intent intent = new Intent(this, page_2.class);
        processIntentData();
        intent.putExtra("FromPage1ToPage2", this.person);
        startActivity(intent);
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