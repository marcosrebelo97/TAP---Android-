package com.example.marcos.gerenciamentorit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdiconarProfessor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiconar_professor);
    }

    public void salvar (View view){
        Intent x = new Intent(AdiconarProfessor.this, CorpoDocente.class);
        startActivity(x);
    }
}
