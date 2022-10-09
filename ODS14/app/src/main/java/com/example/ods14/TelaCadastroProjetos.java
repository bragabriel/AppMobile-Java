package com.example.ods14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroProjetos extends AppCompatActivity{

    private EditText Nomeprojeto;
    private EditText Cidadeprojeto;
    private EditText Estadoprojeto;
    private EditText Descricao;
    private Button botaoCadastrar2;
    private projeto projeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_projetos);

        Nomeprojeto = findViewById(R.id.Nomeprojeto);
        Cidadeprojeto = findViewById(R.id.Cidadeprojeto);
        Estadoprojeto = findViewById(R.id.Estadoprojeto);
        Descricao = findViewById(R.id.Descricao);
        botaoCadastrar2 = findViewById(R.id.botaoCadastrar2);


        botaoCadastrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validaNomeprojeto()){
                    if(validaCidadeprojeto()){
                        if(validaEstadoprojeto()){
                            projeto = new projeto();
                            projeto.setNome(Nomeprojeto.getText().toString());
                            projeto.setCidade(Cidadeprojeto.getText().toString());
                            projeto.setEstado(Estadoprojeto.getText().toString());
                            projeto.setDescricao(Descricao.getText().toString());
                            //Viwprojetos.Listaprojeto.add(projeto);
                            finish();
                            Toast.makeText(TelaCadastroProjetos.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

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

    public boolean validaNomeprojeto(){
        String textoNome = Nomeprojeto.getText().toString();
        if(textoNome.isEmpty())
            return false;

        return true;
    }

    public boolean validaCidadeprojeto(){
        String textocidade = Cidadeprojeto.getText().toString();
        if(textocidade.isEmpty())
            return false;

        return true;
    }

    public boolean validaEstadoprojeto(){
        String textoestado = Estadoprojeto.getText().toString();
        if(textoestado.isEmpty())
            return false;

        return true;
    }


    }




