package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import model.Usuario;

public class UsuarioDAO implements IUsuarioDAO{

    private SQLiteDatabase escreve; //quem vamos usar para gravar algo no banco
    private SQLiteDatabase le; //para ler algo do banco

    //Constructor
    public UsuarioDAO(Context context) {

        //Criando um objeto da classe DBHelper
        DBHelper db = new DBHelper(context);

        this.escreve = db.getWritableDatabase();
        this.le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Usuario usuario) { //metodo salvar que é chamado em telacadastroUsuario para salvar os dados

        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());
        cv.put("senha", usuario.getSenha());

        try{
            escreve.insert(DBHelper.TABELA_USUARIOS, null, cv);
            Log.i("INFO", "Usuário salvo com sucesso!"); //add no banco de dados
        }catch (Exception e){
            Log.i("INFO", "Erro ao salvar usuário! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("email", usuario.getEmail());
        cv.put("senha", usuario.getSenha());

        try {
            //Criando um vetor de String chamado args
            String[] args = {String.valueOf(usuario.getId())};
            //Transformando o ID do usuário em String

            escreve.update(DBHelper.TABELA_USUARIOS, cv, "id=?", args);
            Log.i("INFO", "Usuário atualizado com sucesso!");
        }catch(Exception e){
            Log.i("INFO", "Erro ao atualizar usuário! " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Usuario buscar(String email, String senha) {


        String sql = "SELECT * FROM " + DBHelper.TABELA_USUARIOS + " WHERE email = ? AND senha = ?";
        String[] args = {email, senha};
        Cursor c = le.rawQuery(sql, args); //Rodando a query, dentro de 'le', guardando em 'Cursor "c"'
        Usuario u = new Usuario();


        //Se retornou algo da base de dados
        if(c.getCount() != 0){

            c.moveToFirst(); //Garantindo que estamos no primeiro (pois ele pode retornar mais de um

            int id = c.getInt(c.getColumnIndex("id"));//Pegando o valor que retornar na coluna ID
            String nome_usuario = c.getString(c.getColumnIndex("nome"));
            String email_usuario = c.getString(c.getColumnIndex("email"));
            String senha_usuario = c.getString(c.getColumnIndex("senha"));

            u.setId(id);
            u.setNome(nome_usuario);
            u.setEmail(email_usuario);
            u.setSenha(senha_usuario);
        }

        return u;
    }
}
