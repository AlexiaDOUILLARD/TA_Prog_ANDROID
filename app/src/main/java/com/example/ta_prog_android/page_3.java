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
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class page_3 extends AppCompatActivity {
    private ScrollView scrollView2;
    private EditText editTextTextPersonName2;
    private Switch switch2;
    private ImageButton imageButton, imageButton2, imageButton3;
    private Button button,button3;
    private Button buttonpage3prec;
    boolean isAllFieldsChecked = false;
    boolean clicked_yes = false;
    boolean clicked_no = false;
    boolean clicked_intero = false;
    private TextView textView14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        buttonpage3prec = findViewById(R.id.buttonpage3prec);
        button3 = findViewById(R.id.button3);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        switch2 = findViewById(R.id.switch2);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        textView14 = findViewById(R.id.textView14);

        // Pour de passer de la page 3 à la page 2**/
        buttonpage3prec.setOnClickListener(view -> {
            Intent intent = new Intent(page_3.this, page_2.class);
            page_3.this.startActivity(intent);
        });

        button3.setOnClickListener(view -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                Intent intent = new Intent(page_3.this, page_4.class);
                page_3.this.startActivity(intent);
            }
        });

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
            textView14.setError("please answer this question by clicking a button");
            return false;
        }
        // after all validation return true.
        return true;
    }

    private boolean verification_texte (){
        String s = editTextTextPersonName2.getText().toString();
        List<String> ma_liste = Arrays.asList("Oui", "Non", "oui","non","Yes","No","yes","no");
        if (ma_liste.contains(s)) {
            return true;
        }
        return false;
    }
}