package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import model.Criacao;

import com.example.ods14.R;



public class AdapterCriacao extends
        RecyclerView.Adapter<AdapterCriacao.MyViewHolder> {

    private List<Criacao> criacoes;
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


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
