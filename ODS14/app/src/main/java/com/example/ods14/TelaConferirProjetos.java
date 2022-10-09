package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import adapter.Adapter;

public class TelaConferirProjetos extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conferir_projetos);

        /*
        layout Manager: layout

        Adapter: junção do layout com os dados

        dataSet: dados
        */

        //Conversão de variáveis
        recyclerView = findViewById(R.id.recyclerView);

        //Configurando o Adapter - Instanciando
        Adapter adapter = new Adapter();


        //Configurando o recyclerView:
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //Acessando o LayoutManager, instanciando ele


        //setando o layoutmanager
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        //colocando um adaptador
        recyclerView.setAdapter(adapter);
    }
}