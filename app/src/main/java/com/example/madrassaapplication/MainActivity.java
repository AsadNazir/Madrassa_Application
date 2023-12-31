package com.example.madrassaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button github, gotoApp;
    final private String linkToRepo ="https://github.com/AsadNazir/Madrassa_Application";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        github = findViewById(R.id.githuBtn);
        gotoApp = findViewById(R.id.gototBtn);

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse(linkToRepo));
                startActivity(I);
            }
        });

        gotoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(I);
            }
        });

    }
}