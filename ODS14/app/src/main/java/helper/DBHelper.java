package helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_ODS14";
    public static String TABELA_USUARIOS = "usuarios";
    public static String TABELA_CRIACOES = "criacoes";
                        //Alias 'usuarios as TABELA_USUARIOS'


    public DBHelper(Context context){
        //context para falar da onde está usando ele
        super(context, NOME_DB, null, VERSION);
    }

    //Não tem o app, cria as tabelas
    @Override //Quando criar a classe, vai executar o onCreate com a query
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_USUARIOS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "senha TEXT NOT NULL);";

        try{
            sqLiteDatabase.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela usuários");
        }catch(Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela usuários");
        }
    }

    //Tem o app, atualiza a base de dados
    @Override //Caso lance uma nova versão do app e alteramos algo na tabela, então ele executa o upgrade (Alter tables do SQL por exemplo)
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }

}
