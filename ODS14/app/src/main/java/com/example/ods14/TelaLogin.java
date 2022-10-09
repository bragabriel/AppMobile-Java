package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import model.Usuario;

public class TelaLogin extends AppCompatActivity {

    private Button botaoEntrar;
    private EditText campoEmail;
    private EditText campoSenha;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        botaoEntrar = findViewById(R.id.btEntrar);
        campoEmail = findViewById(R.id.editTextEmailLogin);
        campoSenha = findViewById(R.id.editTextSenhaLogin);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificaEmail()){
                    if(verificaSenha()){
                        usuario = encontraUsuario();
                        if(!usuario.getNome().equals("Errado")){
                            Toast.makeText(TelaLogin.this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
                            abrirTelaPrincipal(view);
                        }else{
                            Toast.makeText(TelaLogin.this, "Email ou Senha incorretos!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(TelaLogin.this, "Informe um senha!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(TelaLogin.this, "Informe um email!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean verificaEmail(){
        String textoEmail = campoEmail.getText().toString();
        if(textoEmail.isEmpty())
            return false;
        return true;
    }

    public boolean verificaSenha(){
        String textoSenha = campoSenha.getText().toString();
        if(textoSenha.isEmpty())
            return false;

        return true;
    }

    public Usuario encontraUsuario(){
        //Percorrendo a lista de usuários

        Usuario u;
        List<Usuario> lista = MainActivity.listaUsuarios;
        int qtdUsuarios = lista.size();
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        for(int i = 0; i < qtdUsuarios; i++){
            u = lista.get(i);
            if(u.getEmail().equals(email) && u.getSenha().equals(senha)){
                return u;
            }
        }

        u = new Usuario();
        u.setNome("Errado");
        return u;
    }

    public void abrirTelaPrincipal(View view){
        //instancia um objeto de “Intent” e passa o objeto de “Usuário” para a activity “TelaPrincipal”.
        Intent intent = new Intent(this, TelaPrincipal.class);
        intent.putExtra("usuario", usuario );
        startActivity(intent);
    }
}