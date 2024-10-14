package it.unisa.di.approidlab.custommclick;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contatto> {
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<Contatto> objects) {
            super(context, resourceId, objects);
            inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
    		if (v == null) {
    			Log.d("DEBUG","Inflating view");
    			v = inflater.inflate(R.layout.list_element, null);
    		}
    		
            Contatto c = getItem(position);
       
			Log.d("DEBUG","contact c="+c);
			
            Button nameButton;
            Button telButton;
            ImageButton fotoButton;
            
            nameButton = (Button) v.findViewById(R.id.elem_lista_nome);
            telButton = (Button) v.findViewById(R.id.elem_lista_telefono);
            fotoButton = (ImageButton) v.findViewById(R.id.elem_lista_foto);
         
            fotoButton.setImageDrawable(c.getPicture());
            nameButton.setText(c.getName());
            telButton.setText(c.getTel());
            
            fotoButton.setTag(position);
            nameButton.setTag(position);
            telButton.setTag(position);
            
            return v;
    }
}

