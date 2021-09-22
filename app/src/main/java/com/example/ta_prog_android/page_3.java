package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Switch;
@SuppressWarnings("FieldCanBeLocal")
public class page_3 extends AppCompatActivity {
    private ScrollView scrollView2;
    private EditText editTextTextPersonName2;
    private Switch switch2;
    private ImageButton imageButton, imageButton2, imageButton3;
    private Button button,button3;
    private Button buttonpage3prec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        buttonpage3prec = findViewById(R.id.buttonpage3prec);

        // Pour de passer de la page 3 à la page 2**/
        buttonpage3prec.setOnClickListener(view -> {
            Intent intent = new Intent(page_3.this, page_2.class);
            page_3.this.startActivity(intent);
        });


    }
}