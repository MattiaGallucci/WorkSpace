package com.example.rubrica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contatto> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resource, List<Contatto> contatti) {
        super(context, resource, contatti);
        inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View v, ViewGroup parent){
        if(v==null){
            v = inflater.inflate(R.layout.list_element, null);
        }

        Contatto c = getItem(position);
        Button nome;
        Button tel;
        ImageButton foto;

        nome = (Button) v.findViewById(R.id.nome);
        tel = (Button) v.findViewById(R.id.numero);
        foto = (ImageButton) v.findViewById(R.id.foto);

        nome.setText(c.getNome());
        tel.setText(c.getNumero());
        foto.setImageDrawable(c.getFoto());

        nome.setTag(position);
        tel.setTag(position);
        foto.setTag(position);

        return v;
    }
}
