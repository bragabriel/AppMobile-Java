package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import adapter.AdapterCriacao;

public class TelaConferirProjetos2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conferir_projetos);

        //recyclerView = findViewById(R.id.recyclerMovimentos);

        //carregarCriacoes();
    }

    public void carregarCriacoes(){

        /*
        //Exibe lista de Projetos no recycler View


        //configurar um apter
        adapterMovimentacao = new AdapterCriacao(listaMovimentacoes, this);

        //configurar um recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterMovimentacao);
        */

    }

}