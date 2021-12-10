package com.example.marcos.gerenciamentorit;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class CorpoDocente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corpo_docente);

        ListView lista = (ListView) findViewById(R.id.lv_CorpoDocente);

        ArrayList<String> docentes = preencher();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, docentes);
        lista.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preencher() {
        ArrayList<String> dados = new ArrayList<>();

        dados.add("Edjar de Sousa Mota");
        dados.add("Edjair de Sousa Mota");
        dados.add("Horácio Fernandes Braga");
        dados.add("David Fernandes Braga");
        dados.add("João Marcos Cavalcanti");
        dados.add("Rafael Giusti");

        return dados;
    }


    public void adicionar (View view){
        Intent intent = new Intent (this, AdiconarProfessor.class);
        startActivity(intent);
    }

    public void addDisciplina (View view){
        Intent x = new Intent(this, Disciplinas.class);
        startActivity(x);
    }
}
