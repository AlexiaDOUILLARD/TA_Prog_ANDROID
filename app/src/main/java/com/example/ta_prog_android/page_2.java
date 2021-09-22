package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page_2 extends AppCompatActivity {
    private Button suivantpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        suivantpage2 = findViewById(R.id.suivantpage2);

        /** Permete de passer de la page 2 à la page 3**/
        suivantpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page_2.this, page_3.class);
                page_2.this.startActivity(intent);
            }
        });

    }

}