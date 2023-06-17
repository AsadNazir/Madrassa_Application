package com.example.madrassaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {


    Button newStudent, EnterRec, ViewRec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //getting views by id

        newStudent = findViewById(R.id.newStuBtn);
        EnterRec = findViewById(R.id.enterRecordBtn);
        ViewRec = findViewById(R.id.viewRecordBtn);

        newStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I= new Intent(Menu.this,EnterNewStudent.class );
                startActivity(I);
            }
        });
    }
}