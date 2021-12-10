package com.example.marcos.gerenciamentorit.ClasseDAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.marcos.gerenciamentorit.Classe.Usuario;
import com.example.marcos.gerenciamentorit.Conexao.ConexaoBD;

public class UsuarioDAO {
    private SQLiteDatabase bd;

    public UsuarioDAO(Context context) {
        this.bd = (new ConexaoBD(context)).getWritableDatabase();
    }

    public boolean addUsuario(Usuario usu) {
        try {
            String sql = "INSERT INTO USUARIO VALUES(NULL,'" + usu.getNome() + "','" + usu.getLogin() + "','" + usu.getSenha() + "')";
            this.bd.execSQL(sql);
            return true;
        } catch (SQLiteException e) {
            Log.e("Erro ao inserir", e.getMessage());
            return false;
        }


    }

    public Boolean acessoUsuario(Usuario usuario) {
        try {

            String sql = "SELECT * FROM usuario WHERE " + "usuario='" + usuario.getLogin() + "' AND senha='" + usuario.getSenha() + "'";
            Cursor cursor = this.bd.rawQuery(sql, null);

            if (cursor.moveToFirst()){
                Log.i("Erro", "Bem-Vindo!");
                return true;

            }else{
                Log.i("Erro", "Acesso negado");
                return false;
            }
        }catch (SQLiteException ex){
            Log.i("Erro", ex.getMessage());
            return false;
        }

    }


}
