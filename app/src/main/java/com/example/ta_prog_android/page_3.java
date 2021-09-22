package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class page_3 extends AppCompatActivity {
    private EditText editTextTextPersonName2; // champs texte
    private ImageButton imageButton, imageButton2, imageButton3; // boutons des images
    private Button button3; // bouton page suivante
    private Button buttonpage3prec; // bouton page précédente
    boolean isAllFieldsChecked = false; // booleen pour vérifier le remplissage des champs
    boolean clicked_yes = false; // booléen pour l'image bouton Yes
    boolean clicked_no = false; // booléen pour l'image bouton Non
    boolean clicked_intero = false; // // booléen pour l'image bouton Je sais pas
    private TextView textView14; // correspond à la première question

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        buttonpage3prec = findViewById(R.id.buttonpage3prec);
        button3 = findViewById(R.id.button3);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        textView14 = findViewById(R.id.textView14);

        // Pour de passer de la page 3 à la page 2
        buttonpage3prec.setOnClickListener(view -> {
            Intent intent = new Intent(page_3.this, page_2.class);
            page_3.this.startActivity(intent);
        });

        // Pour de passer de la page 3 à la page 4
        button3.setOnClickListener(view -> {
            isAllFieldsChecked = CheckAllFields();
            if (isAllFieldsChecked) {
                Intent intent = new Intent(page_3.this, page_4.class);
                page_3.this.startActivity(intent);
            }
        });

        // Listener sur les 3 images boutons
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
            textView14.setError("please answer this question by clicking a button");
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
}