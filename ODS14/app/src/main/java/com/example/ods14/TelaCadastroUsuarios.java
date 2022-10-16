package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.UsuarioDAO;
import model.Usuario;

public class TelaCadastroUsuarios extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoSenha;
    private Button botaoCadastrar;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        campoNome = findViewById(R.id.editTextNomeCadastro);
        campoEmail = findViewById(R.id.editTextEmailCadastro);
        campoSenha = findViewById(R.id.editTextSenhaCadastro);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validaNome()){
                    if(validaEmail()){
                        if(validaSenha()){
                            usuario = new Usuario();
                            usuario.setNome(campoNome.getText().toString());
                            usuario.setEmail(campoEmail.getText().toString());
                            usuario.setSenha(campoSenha.getText().toString());

                            //Não vamos mais inserir na lista
                            //MainActivity.listaUsuarios.add(usuario);

                            //Vamos inserir no banco
                            if(cadastrarUsuario()){
                                //Deu certo
                                finish();
                                Toast.makeText(TelaCadastroUsuarios.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            }else {
                                //Não de certo o cadastro
                                Toast.makeText(TelaCadastroUsuarios.this, "Erro ao realizar cadastro!", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(TelaCadastroUsuarios.this, "Informe uma senha!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(TelaCadastroUsuarios.this, "Informe um email!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(TelaCadastroUsuarios.this, "Informe um nome!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validaNome(){
        String textoNome = campoNome.getText().toString();
        if(textoNome.isEmpty())
            return false;

        return true;
    }

    public boolean validaEmail(){
        String textoEmail = campoEmail.getText().toString();
        if(textoEmail.isEmpty())
            return false;

        return true;
    }

    public boolean validaSenha(){
        String textoSenha = campoSenha.getText().toString();
        if(textoSenha.isEmpty())
            return false;

        return true;
    }

    public boolean cadastrarUsuario(){

        usuario = new Usuario();

        usuario.setNome(campoNome.getText().toString());
        usuario.setEmail(campoEmail.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());

        UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());

        return usuarioDAO.salvar(usuario);
    }
}