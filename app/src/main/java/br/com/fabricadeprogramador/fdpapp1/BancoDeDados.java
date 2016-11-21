package br.com.fabricadeprogramador.fdpapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 17/11/16.
 */

public class BancoDeDados extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "fdpdb";
    public static final int VERSAO_BANCO = 2;

    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE tbpessoa (id integer primary key, nome text, telefone text, email text)";
            db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            String sql = "DROP TABLE IF EXISTS tbpessoa";
            db.execSQL(sql);
            onCreate(db);
    }


    public void salvar(Pessoa pessoa){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("telefone", pessoa.getTelefone());
        values.put("email", pessoa.getEmail());

        if( pessoa.getId() == null) {
            db.insert("tbpessoa", null, values);
        } else {
            String[] arg = new String[1];
            arg[0] = pessoa.getId().toString();

            db.update("tbpessoa", values, "id = ?", arg);
        }
        db.close();
    }

    public List<Pessoa> buscarTodos(){
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbpessoa";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() ){

            do{
              Pessoa pessoa = new Pessoa();
              pessoa.setId(cursor.getLong(0));
              pessoa.setNome(cursor.getString(1));
              pessoa.setTelefone(cursor.getString(2));
              pessoa.setEmail(cursor.getString(3));

              lista.add(pessoa);
            } while(cursor.moveToNext());
        }


        return lista;
    }
}
