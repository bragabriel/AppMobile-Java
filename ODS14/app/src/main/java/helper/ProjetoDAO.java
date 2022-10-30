package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.ProjetosMarinhos;
import model.Usuario;

public class ProjetoDAO implements IProjetoDAO {

    private SQLiteDatabase escreve; //quem vamos usar para gravar algo no banco
    private SQLiteDatabase le; //para ler algo do banco

    public ProjetoDAO(Context context) {
        DBHelper db = new DBHelper(context);
        this.escreve = db.getWritableDatabase();
        this.le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(ProjetosMarinhos projeto) {

        ContentValues cv = new ContentValues();
        cv.put("nome", projeto.getNome());
        cv.put("localizacao", projeto.getLocalizacao());
        cv.put("descricao", projeto.getDescricao());

        try {
            escreve.insert(DBHelper.TABELA_PROJETOS, null, cv);
            Log.i("INFO", "Projeto salvo com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "Erro ao salvar projeto! " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(ProjetosMarinhos projeto) {
        try {
            String[] args = {String.valueOf(projeto.getId())};
            escreve.delete(DBHelper.TABELA_PROJETOS, "id=?", args);
            Log.i("INFO", "Projeto excluido com sucesso!");
        } catch (Exception e) {
            Log.i("INFO", "Erro ao excluir projeto!" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<ProjetosMarinhos> buscar() {
        List<ProjetosMarinhos> projeto = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABELA_PROJETOS+" WHERE id=?;";

        String[] args ={"1"};
        Cursor c = le.rawQuery(sql, args);
        while (c.moveToNext()) {

            int idProjeto = c.getInt(c.getColumnIndex("id"));
            String nome = c.getString(c.getColumnIndex("nome"));
            String localizacao = c.getString(c.getColumnIndex("localizacao"));
            String descricao = c.getString(c.getColumnIndex("descricao"));

            ProjetosMarinhos projetoNovo = new ProjetosMarinhos(nome, localizacao, descricao);
            int idUsuario = c.getInt(c.getColumnIndex("idUsuario"));
            projetoNovo.setId(idUsuario);

            projeto.add(projetoNovo);
        }

    return projeto;
    }
}
