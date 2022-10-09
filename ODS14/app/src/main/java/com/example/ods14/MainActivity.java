package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class MainActivity extends AppCompatActivity {

    public static List<Usuario> listaUsuarios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Click no botão 'Cadastrar' na tela inicial
    public void abrirTelaCadastro(View view){
        startActivity(new Intent(this, TelaCadastroUsuarios.class));
    }

    //Click no botão 'Já tenho conta'
    public void abrirTelaLogin(View view) {
        startActivity(new Intent(this, TelaLogin.class));
    }


}

