package com.example.ta_prog_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class page_2 extends AppCompatActivity {
    private Button suivantpage2, precedentpage2;
    private CheckBox checkBox1_page2;
    private CheckBox checkBox2_page2;
    private CheckBox checkBox3_page2;
    boolean BooleanCheck = false;
    boolean BooleanCheck2 = false;
    boolean BooleanCheck3 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        suivantpage2 = findViewById(R.id.suivantpage2);
        precedentpage2 = findViewById(R.id.precedentpage2);
        checkBox1_page2 = findViewById(R.id.checkBox1_page2);
        checkBox2_page2 = findViewById(R.id.checkBox2_page2);
        checkBox3_page2 = findViewById(R.id.checkBox3_page2);




        //Pour de passer de la page 2 à la page 3 **/
        suivantpage2.setOnClickListener(view -> {
            Intent intent = new Intent(page_2.this, page_3.class);
            page_2.this.startActivity(intent);
        });

        // Permet de passer de la page 2 à la page 1**/
        precedentpage2.setOnClickListener(view -> {
            Intent intent = new Intent(page_2.this, page_1.class);
            page_2.this.startActivity(intent);
        });

        // Listener sur les 3 CheckBox
        checkBox1_page2.setOnClickListener(v -> {
            //change boolean value
            BooleanCheck=true;
        });

        checkBox2_page2.setOnClickListener(v -> {
            //change boolean value
            BooleanCheck2=true;
        });

        checkBox3_page2.setOnClickListener(v -> {
            //change boolean value
            BooleanCheck3=true;
        });



    }

    //Fonction pour cocher une seul check box à la fois
    private boolean CheckBox_control () {
        if (checkBox1_page2.isChecked()) {
            checkBox2_page2.setSelected(false);
            BooleanCheck2 = false;
            checkBox3_page2.setSelected(false);
            BooleanCheck3 = false;
            return false;

        }
        if (checkBox2_page2.isChecked()) {
            checkBox1_page2.setSelected(false);
            BooleanCheck = false;
            checkBox3_page2.setSelected(false);
            BooleanCheck3 =false;
            return false;
        }
        if (checkBox3_page2.isChecked()) {
            checkBox1_page2.setSelected(false);
            BooleanCheck = false;
            checkBox2_page2.setSelected(false);
            BooleanCheck2 = false;
            return false;

        }
        //Vérifie que au moins une CheckBox est rempli
        if(!BooleanCheck && !BooleanCheck2 && !BooleanCheck3){
            Toast.makeText(page_2.this, "Please answer the last question by choosing a checkbox", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}

