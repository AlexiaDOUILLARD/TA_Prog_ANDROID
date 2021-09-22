package com.example.ta_prog_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class page_2 extends AppCompatActivity {
    private Button suivantpage2;
    private Button precedentpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        suivantpage2 = findViewById(R.id.suivantpage2);
        precedentpage2 = findViewById(R.id.precedentpage2);

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

}