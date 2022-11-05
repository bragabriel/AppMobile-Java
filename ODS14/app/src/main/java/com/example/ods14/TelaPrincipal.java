package com.example.ods14;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ods14.databinding.ActivityTelaPrincipalBinding;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import model.Usuario;

public class TelaPrincipal extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTelaPrincipalBinding binding;

    private TextView textViewUsuario;
    private Usuario usuario;

    //private List<Criacao> listaMovimentacoes = new ArrayList<>();
    private Adapter adapterMovimentacao;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTelaPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_principal);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        textViewUsuario = findViewById(R.id.textViewUsuario);
        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        carregaResumo();


        //Botão abrir tela cadastrar projeto
        /*
        binding.fabAdicionarProjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaProjeto(view);
            }
        });
        */
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_principal);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void carregaResumo(){
        textViewUsuario.setText("Olá " + usuario.getNome() + ", bem-vindo!");
    }

    //botão
    public void abrirTelaProjeto(View view){
        startActivity(new Intent(this, TelaCadastroProjetos.class));
    }

    public void abrirTelaCadastrarProjeto(View view) {
        startActivity(new Intent(this, TelaCadastroProjetos.class));
    }

    public void abrirTelaConferirProjetos(View view) {
        //startActivity(new Intent(this, Viwprojetos.class));
        startActivity(new Intent(this, TelaConferirProjetos.class));
    }


    public void abrirTelaODS(View view) {
        startActivity(new Intent(this, TelaODS.class));
    }


}