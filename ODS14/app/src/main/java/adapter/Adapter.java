package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ods14.R;


public class Adapter extends
        RecyclerView.Adapter<Adapter.MyViewHolder> {

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

        //Exibindo os itens
        holder.nome.setText("Projeto TAMAR");
        holder.ano.setText("2016");
        holder.localizacao.setText("Ubatuba, SP");
    }

    @Override
    public int getItemCount() {
        return 5; //quantidade de itens retornados na lista
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



    /*private List<Criacao> criacoes;
    private Context context;

    public AdapterCriacao(List<Criacao> movimentacoes, Context context){
        this.criacoes = movimentacoes;
        this.context = context;
    }

    @Override
    public AdapterCriacao.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movimentacao, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCriacao.MyViewHolder holder, int position) {
        Criacao criacao = criacoes.get(position);

        holder.titulo.setText(criacao.getDescricao());
        holder.valor.setText(String.valueOf(criacao.getValor()));
        holder.categoria.setText(criacao.getCategoria());

        if(criacao.getTipo() == "d" || criacao.getTipo().equals("d")){
            holder.valor.setTextColor(context.getResources().getColor(R.color.colorAccent));
            holder.valor.setText("- " + criacao.getValor());
        }
    }

    @Override
    public int getItemCount() {
        return criacoes.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView titulo, valor, categoria;

*/

    }

}
