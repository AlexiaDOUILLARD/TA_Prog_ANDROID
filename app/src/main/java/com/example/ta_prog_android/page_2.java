package com.example.ta_prog_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class page_2 extends AppCompatActivity {

    private static final String TAG = "Page_2 Stat :";
    private Button suivantpage2, precedentpage2;
    private CheckBox checkBox1_page2, checkBox2_page2, checkBox3_page2;
    boolean BooleanCheck = false;
    boolean BooleanCheck2 = false;
    boolean BooleanCheck3 = false;
    boolean checkBoxControl = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        suivantpage2 = findViewById(R.id.suivantpage2);
        precedentpage2 = findViewById(R.id.precedentpage2);
        checkBox1_page2 = findViewById(R.id.checkBox1_page2);
        checkBox2_page2 = findViewById(R.id.checkBox2_page2);
        checkBox3_page2 = findViewById(R.id.checkBox3_page2);

        processIntentData();

        //Pour de passer de la page 2 à la page 3 **/
        suivantpage2.setOnClickListener(view -> {
            checkBoxControl = CheckBox_control();
            if (checkBoxControl) {
                Intent intent = new Intent(page_2.this, page_3.class);
                page_2.this.startActivity(intent);
            }
        });

        // Permet de passer de la page 2 à la page 1**/
        precedentpage2.setOnClickListener(view -> {
            Intent intent = new Intent(page_2.this, page_1.class);
            page_2.this.startActivity(intent);
        });

        // Listener sur les 3 CheckBox
        checkBox1_page2.setOnClickListener(view -> BooleanCheck = ((CheckBox) view).isChecked());

        checkBox2_page2.setOnClickListener(view -> BooleanCheck2 = ((CheckBox) view).isChecked());

        checkBox3_page2.setOnClickListener(view -> BooleanCheck3 = ((CheckBox) view).isChecked());

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
            // intent may store different data. To get the one matching the Person class,
            // we need the key "FromActivity1ToActivity2" which was used for transfer
            // No need to calls "new()" for allocating memory to transferredPerson
            Person transferredPerson = intent.getParcelableExtra("FromAccueilToPage1");
            if (transferredPerson != null) {
                transferredPerson.print();
            } else {
                Log.d(page_2.TAG, "No Person found after transfer from Activity1");
            }
        } else {
            Log.d(page_2.TAG, "Error when transferring from Activity1");
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

