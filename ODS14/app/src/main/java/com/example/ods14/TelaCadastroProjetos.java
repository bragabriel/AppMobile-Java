package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import helper.ProjetoDAO;
import model.ProjetosMarinhos;

public class TelaCadastroProjetos extends AppCompatActivity{

    //mesmo esquema de criar um usuario criamos os componentes que serão passados pelo id da aplicação
    private EditText nome_projeto;
    private EditText cidade_projeto;
    private EditText descricao_projeto;
    private Button btn_cadastrar_projeto;
    private ProjetosMarinhos projetosMarinhos;
    private ProjetoDAO projetoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_projetos);

        //buscando os ids passados pela actity
        nome_projeto = findViewById(R.id.NomeProjeto);
        cidade_projeto = findViewById(R.id.CidadeProjeto);
        descricao_projeto = findViewById(R.id.DescricaoProjeto);
        btn_cadastrar_projeto = findViewById(R.id.btnCadastrarProjeto);


        btn_cadastrar_projeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validaNomeProjeto()){
                    if(validaCidadeProjeto()) {
                        if(validaDescricaoProjeto()){
                            projetosMarinhos = new ProjetosMarinhos(nome_projeto.getText().toString(), cidade_projeto.getText().toString(), descricao_projeto.getText().toString());
                            projetoDAO = new ProjetoDAO(getApplicationContext()); //chama o metodo salvar em ProjetoDAO
                            if (projetoDAO.salvar(projetosMarinhos)) {
                                finish();
                                Toast.makeText(TelaCadastroProjetos.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(TelaCadastroProjetos.this, "Informe um Estado para o projeto!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(TelaCadastroProjetos.this, "Informe uma cidade para o projeto!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(TelaCadastroProjetos.this, "Informe um nome para o projeto!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public boolean validaNomeProjeto(){
        String textoNome = nome_projeto.getText().toString();
        if(textoNome.isEmpty())
            return false;

        return true;
    }

    public boolean validaCidadeProjeto(){
        String textoCidade = cidade_projeto.getText().toString();
        if(textoCidade.isEmpty())
            return false;

        return true;
    }

    public boolean validaDescricaoProjeto(){
        String textoDescricao = descricao_projeto.getText().toString();
        if(textoDescricao.isEmpty())
            return false;

        return true;
    }

}