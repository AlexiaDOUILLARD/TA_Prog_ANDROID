package com.example.ta_prog_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class page_2 extends AppCompatActivity {
    private Button suivantpage2, precedentpage2;
    private CheckBox checkBox1_page2;
    private CheckBox checkBox2_page2;
    private CheckBox checkBox3_page2;


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

    }

    //Fonction pour cocher une seul check box à la fois
    public void CheckBox_control (View v ){
        if (checkBox1_page2.isSelected()){
            checkBox2_page2.setSelected(false);
            checkBox3_page2.setSelected(false);

        }else if (checkBox2_page2.isSelected()){
            checkBox1_page2.setSelected(false);
            checkBox3_page2.setSelected(false);
        }else{
            checkBox1_page2.setSelected(false);
            checkBox2_page2.setSelected(false);

        }
    }

}