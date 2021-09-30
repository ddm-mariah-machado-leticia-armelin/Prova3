package com.example.prova3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CadastraAluno extends AppCompatActivity {
    private EditText txtNome;
    private EditText txtNota1;
    private EditText txtNota2;
    private Button btnAdiciona;
    private Button btnCancela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_aluno);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        btnAdiciona = (Button) findViewById(R.id.btnAdiciona);
        btnCancela = (Button) findViewById(R.id.btnCancela);

        btnAdiciona.setOnClickListener( new EscutadorAdiciona() );
        btnCancela.setOnClickListener( new EscutadorCancela() );
    }

    public class EscutadorAdiciona implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String nome, nota1, nota2;

            nome = txtNome.getText().toString();
            nota1 = txtNota1.getText().toString();
            nota2 = txtNota2.getText().toString();

            Double nota1Number = Double.parseDouble(nota1);
            Double nota2Number = Double.parseDouble(nota2);

            Intent i = new Intent();

            i.putExtra("nome", nome);
            i.putExtra("n1", nota1);
            i.putExtra("n2", nota2);

            setResult(RESULT_OK, i);

            finish();
        }
    }

    public class EscutadorCancela implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            Intent i = new Intent();

            setResult(RESULT_CANCELED);

            finish();
        }
    }
}