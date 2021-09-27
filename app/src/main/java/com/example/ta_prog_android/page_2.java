package com.example.ta_prog_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class page_2 extends AppCompatActivity {

    private Person person;
    private static final String TAG = "Page_2 Stat :";
    private CheckBox checkBox1_page2, checkBox2_page2, checkBox3_page2;
    boolean BooleanCheck = false;
    boolean BooleanCheck2 = false;
    boolean BooleanCheck3 = false;
    boolean checkBoxControl = false;
    private Spinner spinner3, spinner4, spinner2, spinner8, spinner6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        checkBox1_page2 = findViewById(R.id.checkBox1_page2);
        checkBox2_page2 = findViewById(R.id.checkBox2_page2);
        checkBox3_page2 = findViewById(R.id.checkBox3_page2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner2 = findViewById(R.id.spinner2);
        spinner8 = findViewById(R.id.spinner8);
        spinner6 = findViewById(R.id.spinner6);

        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson = intent.getParcelableExtra("FromPage1ToPage2");
            if (transferredPerson != null) {
                this.person = transferredPerson;
                if (this.person.getCardiacProblem().toString().equals("OUI")) {
                    spinner3.setSelection(getIndex(spinner3, "Oui"));
                } else if (this.person.getCardiacProblem().toString().equals("NON")) {
                    spinner3.setSelection(getIndex(spinner3, "Non"));
                }
                if (this.person.getCholesterolProblem().toString().equals("OUI")) {
                    spinner2.setSelection(getIndex(spinner2, "Oui"));
                } else if (this.person.getCholesterolProblem().toString().equals("NON")) {
                    spinner2.setSelection(getIndex(spinner2, "Non"));
                }
                if (this.person.getDiabetesProblem().toString().equals("OUI")) {
                    spinner4.setSelection(getIndex(spinner4, "Oui"));

                } else if (this.person.getDiabetesProblem().toString().equals("NON")) {
                    spinner4.setSelection(getIndex(spinner4, "Non"));
                }
                if (this.person.getHypertensionProblem().toString().equals("OUI")) {
                    spinner8.setSelection(getIndex(spinner8, "Oui"));
                } else if (this.person.getHypertensionProblem().toString().equals("NON"))
                    spinner8.setSelection(getIndex(spinner8, "Non"));
                }
                if (this.person.getFamilyHeartProblem().toString().equals("OUI")) {
                    spinner6.setSelection(getIndex(spinner6, "Oui"));
                } else if (this.person.getFamilyHeartProblem().toString().equals("NON")) {
                    spinner6.setSelection(getIndex(spinner6, "Non"));
                } else if (this.person.getFamilyHeartProblem().toString().equals("NE_SAIT_PAS")) {
                    spinner6.setSelection(getIndex(spinner6, "Je ne sais pas"));
                }
                if (this.person.getImc().toString().equals("OUI")) {
                    checkBox1_page2.isChecked();
                } else if (this.person.getImc().toString().equals("NON")) {
                    checkBox2_page2.isChecked();
                } else if (this.person.getImc().toString().equals("NE_SAIT_PAS")) {
                    checkBox3_page2.isChecked();
                }
            else {
                Person transferredPerson2 = intent.getParcelableExtra("FromPage3ToPage2");
                if (transferredPerson2 != null) {
                    this.person = transferredPerson2;
                    if (this.person.getCardiacProblem().toString().equals("OUI")) {
                        spinner3.setSelection(getIndex(spinner3, "Oui"));
                    } else if (this.person.getCardiacProblem().toString().equals("NON")) {
                        spinner3.setSelection(getIndex(spinner3, "Non"));
                    }
                    if (this.person.getCholesterolProblem().toString().equals("OUI")) {
                        spinner2.setSelection(getIndex(spinner2, "Oui"));
                    } else if (this.person.getCholesterolProblem().toString().equals("NON")) {
                        spinner2.setSelection(getIndex(spinner2, "Non"));
                    }
                    if (this.person.getDiabetesProblem().toString().equals("OUI")) {
                        spinner4.setSelection(getIndex(spinner4, "Oui"));

                    } else if (this.person.getDiabetesProblem().toString().equals("NON")) {
                        spinner4.setSelection(getIndex(spinner4, "Non"));
                    }
                    if (this.person.getHypertensionProblem().toString().equals("OUI")) {
                        spinner8.setSelection(getIndex(spinner8, "Oui"));
                    } else if (this.person.getHypertensionProblem().toString().equals("NON"))
                        spinner8.setSelection(getIndex(spinner8, "Non"));
                    }
                    if (this.person.getFamilyHeartProblem().toString().equals("OUI")) {
                        spinner6.setSelection(getIndex(spinner6, "Oui"));
                    } else if (this.person.getFamilyHeartProblem().toString().equals("NON")) {
                        spinner6.setSelection(getIndex(spinner6, "Non"));
                    } else if (this.person.getFamilyHeartProblem().toString().equals("NE_SAIT_PAS")) {
                        spinner6.setSelection(getIndex(spinner6, "Je ne sais pas"));
                    }
                    if (this.person.getImc().toString().equals("OUI")) {
                        checkBox1_page2.setChecked(true);
                    } else if (this.person.getImc().toString().equals("NON")) {
                        checkBox2_page2.setChecked(true);
                    } else if (this.person.getImc().toString().equals("NE_SAIT_PAS")) {
                        checkBox3_page2.setChecked(true);
                    }
                }
            }
        // Listener sur les 3 CheckBox
        checkBox1_page2.setOnClickListener(view -> BooleanCheck = ((CheckBox) view).isChecked());

        checkBox2_page2.setOnClickListener(view -> BooleanCheck2 = ((CheckBox) view).isChecked());

        checkBox3_page2.setOnClickListener(view -> BooleanCheck3 = ((CheckBox) view).isChecked());
    }

    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }
        return 0;
    }

    //Fonction pour cocher une seul check box à la fois
    public boolean CheckBox_control() {
        if ((!BooleanCheck) & (!BooleanCheck2) & (!BooleanCheck3)) {
            Toast.makeText(page_2.this, "Please answer the last question by checking a box", Toast.LENGTH_LONG).show();
            return false;
        }
        if (BooleanCheck & BooleanCheck2 & !BooleanCheck3) {
            Toast.makeText(page_2.this, "You cannot check two boxes for the last question", Toast.LENGTH_LONG).show();
            return false;
        }
        if (BooleanCheck & BooleanCheck3 & !BooleanCheck2) {
            Toast.makeText(page_2.this, "You cannot check two boxes for the last question", Toast.LENGTH_LONG).show();
            return false;
        }
        if (BooleanCheck & BooleanCheck2 & BooleanCheck3) {
            Toast.makeText(page_2.this, "You cannot check two boxes for the last question", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    // This method (whose name is abritrary) is called by onCreate().
    private void processIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            Person transferredPerson3 = intent.getParcelableExtra("FromPage1ToPage2");
            if (transferredPerson3 !=null){
                this.person = transferredPerson3;
                int pos3 = spinner3.getSelectedItemPosition();
                int pos2 = spinner2.getSelectedItemPosition();
                int pos4 = spinner4.getSelectedItemPosition();
                int pos8 = spinner8.getSelectedItemPosition();
                int pos6 = spinner6.getSelectedItemPosition();

                if (pos3 == 0){
                    this.person.setCardiacProblem(YES_NO.OUI);
                } else if (pos3 == 1){
                    this.person.setCardiacProblem(YES_NO.NON);
                }
                if (pos2 == 0){
                    this.person.setCholesterolProblem(YES_NO.OUI);
                } else if (pos2 == 1){
                    this.person.setCholesterolProblem(YES_NO.NON);
                }
                if (pos4 == 0){
                    this.person.setDiabetesProblem(YES_NO.OUI);
                } else if (pos4 == 1){
                    this.person.setDiabetesProblem(YES_NO.NON);
                }
                if (pos8 == 0){
                    this.person.setHypertensionProblem(YES_NO.OUI);
                } else if (pos8 == 1){
                    this.person.setHypertensionProblem(YES_NO.NON);
                }
                if (pos6 == 0){
                    this.person.setFamilyHeartProblem(YES_NO.OUI);
                } else if (pos6 == 1){
                    this.person.setFamilyHeartProblem(YES_NO.NON);
                }
                else if (pos6 == 2){
                    this.person.setFamilyHeartProblem(YES_NO.NE_SAIT_PAS);
                }
                if (checkBox1_page2.isChecked()) {
                    this.person.setImc(YES_NO.OUI);
                }else if (checkBox2_page2.isChecked()){
                    this.person.setImc(YES_NO.NON);
                } else if (checkBox3_page2.isChecked()){
                    this.person.setImc(YES_NO.NE_SAIT_PAS);
                }
                Log.d(TAG, person.toString());
            }
            else {
                Person transferredPerson4 = intent.getParcelableExtra("FromPage3ToPage2");
                Log.d(TAG, "No Person found after transfer from Page2");
                if (transferredPerson4 !=null){
                    this.person = transferredPerson4;
                    int pos3 = spinner3.getSelectedItemPosition();
                    int pos4 = spinner4.getSelectedItemPosition();
                    int pos2 = spinner2.getSelectedItemPosition();
                    int pos8 = spinner8.getSelectedItemPosition();
                    int pos6 = spinner6.getSelectedItemPosition();
                    if (pos3 == 0){
                        this.person.setCardiacProblem(YES_NO.OUI);
                    } else if (pos3 == 1){
                        this.person.setCardiacProblem(YES_NO.NON);
                    }
                    if (pos4 == 0){
                        this.person.setCholesterolProblem(YES_NO.OUI);
                    } else if (pos4 == 1){
                        this.person.setCholesterolProblem(YES_NO.NON);
                    }
                    if (pos2 == 0){
                        this.person.setDiabetesProblem(YES_NO.OUI);
                    } else if (pos2 == 1){
                        this.person.setDiabetesProblem(YES_NO.NON);
                    }
                    if (pos8 == 0){
                        this.person.setHypertensionProblem(YES_NO.OUI);
                    } else if (pos8 == 1){
                        this.person.setHypertensionProblem(YES_NO.NON);
                    }
                    if (pos6 == 0){
                        this.person.setFamilyHeartProblem(YES_NO.OUI);
                    } else if (pos6 == 1){
                        this.person.setFamilyHeartProblem(YES_NO.NON);
                    }
                    else if (pos6 == 2){
                        this.person.setFamilyHeartProblem(YES_NO.NE_SAIT_PAS);
                    }
                    if (checkBox1_page2.isChecked()) {
                        this.person.setImc(YES_NO.OUI);
                    }else if (checkBox2_page2.isChecked()){
                        this.person.setImc(YES_NO.NON);
                    } else if (checkBox3_page2.isChecked()){
                        this.person.setImc(YES_NO.NE_SAIT_PAS);
                    }
                    Log.d(TAG, person.toString());
                    Log.d(TAG, "Person found after transfer from Page3 to Page2");

                }
            }
    }
    else {
        Log.d(TAG, "Error when transferring from Page2");
    }
}

    public void PreviousPage(View view){
        Intent intent = new Intent(this, page_1.class);
        processIntentData();
        intent.putExtra("FromPage2ToPage1", this.person);
        startActivity(intent);
    }

    public void NextPage(View sender){
        checkBoxControl = CheckBox_control();
        if (checkBoxControl) {
            Intent intent = new Intent(this, page_3.class);
            processIntentData();
            intent.putExtra("FromPage2ToPage3", this.person);
            startActivity(intent);
        }
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

