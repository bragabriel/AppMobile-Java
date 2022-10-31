package helper;

import java.util.List;

import model.ProjetosMarinhos;
import model.Usuario;

public interface IProjetoDAO {

    public boolean salvar(ProjetosMarinhos projetosMarinhos);
    //public boolean atualizar(ProjetosMarinhos ProjetosMarinhos);
    public boolean deletar(ProjetosMarinhos movimentacao);
    public List<ProjetosMarinhos> buscar();

}
