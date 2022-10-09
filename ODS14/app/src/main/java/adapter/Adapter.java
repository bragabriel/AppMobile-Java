package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ods14.R;

import java.util.List;

import model.ProjetosMarinhos;


public class Adapter extends
        RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<ProjetosMarinhos> listaProjetos;

    //Construtor para receber a lista de projetos marinhos
    public Adapter(List<ProjetosMarinhos> lista){
        this.listaProjetos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Recuperando a view com o item da lista
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projetos, parent, false);
                        //LayoutInflater utilizado com o view

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Exibindo os itens da lista
        ProjetosMarinhos projetos = listaProjetos.get(position);

        holder.nome.setText(projetos.getNome());
        holder.ano.setText(projetos.getData());
        holder.localizacao.setText(projetos.getLocalizacao());


    }

    @Override
    public int getItemCount() {
        return listaProjetos.size(); //quantidade de itens retornados na lista
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome, ano, localizacao;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Recuperando os dados que estão vindo do .xml
            nome = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            localizacao = itemView.findViewById(R.id.textLocalizacao);

        }
    }

}
