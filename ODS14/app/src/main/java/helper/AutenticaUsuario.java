package helper;

import android.content.Context;

import model.Usuario;

//Classe que recebe o email e senha e verifica se é valido (se tem alguem com esse email e senha no banco)
public class AutenticaUsuario {

    public boolean valida(String email, String senha, Context context){
        UsuarioDAO usuarioDAO = new UsuarioDAO(context);

        Usuario u = usuarioDAO.buscar(email, senha);

        if(u.getNome() == null){
            return false;
        }

        return true;
    }
}
