package helper;

import model.Usuario;

public interface IUsuarioDAO {

    public boolean salvar(Usuario usuario);
    public boolean atualizar(Usuario usuario);
    public Usuario buscar (String email, String senha);
}
