package com.example.esempio2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Persona> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Persona> objects) {
        super(context, resourceId, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            Log.d("DEBUG", "Inflating view");
            v = inflater.inflate(R.layout.list_element, null);
        }

        Persona p = getItem(position);

        TextView nomeCognome = v.findViewById(R.id.nomeCognome);
        nomeCognome.setText(p.getNome() + " " + p.getCognome());

        TextView telefono = v.findViewById(R.id.telefono);
        telefono.setText(p.getTelefono());

        ImageView foto = v.findViewById(R.id.foto);
        foto.setImageResource(R.drawable.faceplaceholder);

        return v;
    }
}
