package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaODS extends AppCompatActivity {

    private Button btnInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ods);

        btnInternet = findViewById(R.id.botaoODS);

        //botaoEntrar.setOnClickListener(new View.OnClickListener() {
        btnInternet.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ipea.gov.br/ods/ods14.html")));
            }
        });
    }
}