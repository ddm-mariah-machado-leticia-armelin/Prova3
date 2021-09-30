package com.example.prova3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContatos extends ArrayAdapter<Contato> {
    private Context context;

    //ArrayList de objetos do tipo aluno
    private ArrayList<Contato> contatos;

    public AdapterContatos(Context context, ArrayList<Contato> contatos) {
        super(context, R.layout.item_lista, contatos);

        this.context = context;

        this.contatos = contatos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater l1 = LayoutInflater.from(parent.getContext());

        View itemView = l1.inflate(R.layout.item_lista, parent, false);

        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblNota1 = itemView.findViewById(R.id.lblNota1);
        TextView lblNota2 = itemView.findViewById(R.id.lblNota2);
        TextView lblMedia = itemView.findViewById(R.id.lblMedia);

        lblNome.setText(contatos.get(position).getNome());
        lblNota1.setText("Nota 1: "+(contatos.get(position).getNota1()).toString());
        lblNota2.setText("Nota 2: "+(contatos.get(position).getNota2().toString()));
        lblMedia.setText("Média: "+(contatos.get(position).getMedia()).toString());

        return itemView;
    }
}
