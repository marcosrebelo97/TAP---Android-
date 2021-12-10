package com.example.marcos.gerenciamentorit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcos.gerenciamentorit.Classe.Usuario;
import com.example.marcos.gerenciamentorit.ClasseDAO.UsuarioDAO;

public class NovoUsuario extends AppCompatActivity {

    private Button buttonSalvar;
    private EditText nome;
    private EditText login;
    private EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        nome= (EditText) findViewById(R.id.editTextNome);
        login = (EditText) findViewById(R.id.editTextLoginNovo);
        senha= (EditText) findViewById(R.id.editTextSenhaNova);




        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().equals("")){
                    Toast.makeText(NovoUsuario.this,"Preencha o campo nome!",Toast.LENGTH_SHORT).show();
                }else if(login.getText().toString().equals("")){
                    Toast.makeText(NovoUsuario.this,"Preencha o campo login!",Toast.LENGTH_SHORT).show();

                }else if(senha.getText().toString().equals("")){
                    Toast.makeText(NovoUsuario.this,"Preencha o campo senha!",Toast.LENGTH_SHORT).show();

                }else{
                    Usuario usuario= new Usuario();
                    UsuarioDAO usuarioDAO= new UsuarioDAO(NovoUsuario.this);
                    usuario.setNome(nome.getText().toString());
                    usuario.setLogin(login.getText().toString().trim());
                    usuario.setSenha(senha.getText().toString().trim());
                    if(usuarioDAO.addUsuario(usuario)){
                        Toast.makeText(NovoUsuario.this,"Usuário cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(NovoUsuario.this,TelaLogin.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(NovoUsuario.this,"Erro ao cadastrar!",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
