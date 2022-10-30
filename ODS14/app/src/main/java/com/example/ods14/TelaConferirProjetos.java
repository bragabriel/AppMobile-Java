package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import helper.ProjetoDAO;
import model.ProjetosMarinhos;

public class TelaConferirProjetos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProjetoDAO projetoDAO;

    //Array list com lista de projetos marinhos
    private List<ProjetosMarinhos> listaProjetosMarinhos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conferir_projetos);

        /*
        layout Manager: layout

        Adapter: junção do layout com os dados

        dataSet: dados
        */

        projetoDAO = new ProjetoDAO(getApplicationContext());

        //Conversão de variáveis
        recyclerView = findViewById(R.id.recyclerView);

        //chamando o método de listagem de projetos marinhos
        listaProjetosMarinhos = projetoDAO.buscar();

        //Configurando o Adapter - Instanciando
        Adapter adapter = new Adapter(listaProjetosMarinhos);

        //Configurando o recyclerView:
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        //Acessando o LayoutManager, instanciando ele


        //setando o layoutmanager
        recyclerView.setLayoutManager(layoutManager);

        //tamanho de tela fixo
        recyclerView.setHasFixedSize(true);

        //colocando um adaptador
        recyclerView.setAdapter(adapter);
    }

    public void criarProjetosMarinhos(){

        ProjetosMarinhos projeto = new ProjetosMarinhos("Projeto Tamar", "1988", "Ubatuba, SP");
        listaProjetosMarinhos.add(projeto);

        ProjetosMarinhos projeto2 = new ProjetosMarinhos("Projeto Verde Mar", "2014", "Rio de Janeiro, RJ");
        listaProjetosMarinhos.add(projeto2);

        ProjetosMarinhos projeto3 = new ProjetosMarinhos("Projeto Albatroz", "2013", "Ubatuba, SP");
        listaProjetosMarinhos.add(projeto3);

        ProjetosMarinhos projeto4 = new ProjetosMarinhos("Projeto Pescador Amigo", "2008", "São Paulo, Bertioga, Garujá e Santos");
        listaProjetosMarinhos.add(projeto4);

        ProjetosMarinhos projeto5 = new ProjetosMarinhos("Projeto Ecosurf", "2000", "Rio Grande do Sul, RS");
        listaProjetosMarinhos.add(projeto5);

    }
}