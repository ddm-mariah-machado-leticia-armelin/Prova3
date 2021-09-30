package com.example.prova3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnInsereAluno;
    private ListView listaAlunos;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private AdapterContatos adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsereAluno = (Button) findViewById(R.id.inserir);
        btnInsereAluno.setOnClickListener( new EscutadorInsereAluno() );
        listaAlunos = findViewById( R.id.listView );
        adaptador = new AdapterContatos( this, contatos );
        listaAlunos.setAdapter( adaptador );
        EscutadorLista el = new EscutadorLista();
        listaAlunos.setOnItemClickListener( el );
        listaAlunos.setLongClickable( true );
        listaAlunos.setOnItemLongClickListener( el );
    }

    public class EscutadorInsereAluno implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent i = new Intent( getApplicationContext(), CadastraAluno.class);
            startActivityForResult(i, 1);
        }
    }

    public class EscutadorLista implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Contato a = contatos.get(i);
            String resp = "";
            resp += "Nome: "+a.getNome() + "\n";
            resp += "Nota 1: "+a.getNota1() + "\n";
            resp += "Nota 2: "+a.getNota2() + "\n";
            resp += "Média: "+a.getMedia();
            Toast.makeText(MainActivity.this, resp, Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            contatos.remove(i);
            adaptador.notifyDataSetChanged();
            return true;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        switch ( requestCode ) {
            case 1:
                if(resultCode==RESULT_OK) {
                    String nome = i.getStringExtra("nome");
                    Double nota1 = Double.parseDouble(i.getStringExtra("n1"));
                    Double nota2 = Double.parseDouble(i.getStringExtra("n2"));
                    Contato a = new Contato(nome, nota1, nota2);
                    contatos.add(a);
                    adaptador.notifyDataSetChanged();
                }
        }
    }

}