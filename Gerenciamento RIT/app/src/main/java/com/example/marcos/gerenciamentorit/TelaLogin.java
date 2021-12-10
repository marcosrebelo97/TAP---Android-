package com.example.marcos.gerenciamentorit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcos.gerenciamentorit.Classe.Usuario;
import com.example.marcos.gerenciamentorit.ClasseDAO.UsuarioDAO;
import com.example.marcos.gerenciamentorit.Conexao.ConexaoBD;

public class TelaLogin extends AppCompatActivity {

    private Button buttonCadastrar;
    private Button buttonEntrar;
    private EditText login;
    private EditText senha;
    private ConexaoBD conexaoBD;
    private SQLiteDatabase con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        login = (EditText) findViewById(R.id.editTextLogin);
        senha= (EditText) findViewById(R.id.editTextSenha);


        try {
            conexaoBD= new ConexaoBD(this);
            con= conexaoBD.getReadableDatabase();
            AlertDialog.Builder dig=  new AlertDialog.Builder(this);
            dig.setMessage("Conexão realizada!");
            dig.setNeutralButton("OK",null);
            dig.show();
        }catch (SQLiteException e){
            AlertDialog.Builder dig=  new AlertDialog.Builder(this);
            dig.setMessage("Conexão não realizada!");
            dig.setNeutralButton("OK",null);
            dig.show();

        }




        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TelaLogin.this, NovoUsuario.class);
                startActivity(intent);
                finish();
            }
        });


        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.getText().toString().equals("")){
                    Toast.makeText(TelaLogin.this,"Preencha o campo login!",Toast.LENGTH_LONG).show();
                }else if(senha.getText().toString().equals("")){
                    Toast.makeText(TelaLogin.this,"Preencha o campo senha!",Toast.LENGTH_LONG).show();
                }else{
                    Usuario usuario= new Usuario();
                    UsuarioDAO usuarioDAO= new UsuarioDAO(TelaLogin.this);
                    usuario.setLogin(login.getText().toString().trim());
                    usuario.setSenha(senha.getText().toString().trim());
                    if(usuarioDAO.acessoUsuario(usuario)){
                        Toast.makeText(TelaLogin.this,"Seja Bem-vindo!",Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(TelaLogin.this,CorpoDocente.class);
                        startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(TelaLogin.this,"Usuário/Senha inválidos!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }


}
