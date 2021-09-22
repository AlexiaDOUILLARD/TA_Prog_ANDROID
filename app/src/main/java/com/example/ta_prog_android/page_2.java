package com.example.ta_prog_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

public class page_2 extends AppCompatActivity {
    private Spinner spinner3, spinner2, spinner4, spinner8, spinner6;
    private CheckBox checkBox1,checkBox2,checkBox3;
    private Button precedentpage2, suivantpage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        suivantpage2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity() {
        Intent intent = new Intent(this, page_3.class);
        startActivity(intent);
    }
}