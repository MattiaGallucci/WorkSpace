package com.example.esempiotelematico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Oggetto> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resource, List<Oggetto> oggetti) {
        super(context, resource, oggetti);
        inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = inflater.inflate(R.layout.list_element, null);
        }

        Oggetto o = getItem(position);

        TextView nome = v.findViewById(R.id.nome);
        nome.setText(o.getNome());
        TextView quantita = v.findViewById(R.id.quantita);
        quantita.setText(String.valueOf(o.getQuantita()));
        ImageView immagine = v.findViewById(R.id.immagine);
        immagine.setImageDrawable(o.getImmagine());

        nome.setTag(position);
        quantita.setTag(position);
        immagine.setTag(position);

        return v;
    }
}