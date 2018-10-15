package com.example.alumno.practica4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumno.practica4.DataItem;
import com.example.alumno.practica4.R;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<DataItem> {

    Activity contexto;
    // Contructor del adaptador usando el contexto de la aplicacion actual

    Adaptador(Activity contexto, ArrayList<DataItem> datos) {

        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.itemrow, datos);
        this.contexto = contexto;
    }
    // Metodo que dibuja la Vista de cada Opcion
// Se invoca cada vez que haya que mostrar un elemento de la lista.
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.itemrow, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        DataItem mielemento=getItem(position);

       ImageView titulo=(ImageView)item.findViewById(R.id.imageView);
        TextView subtitulo = (TextView)item.findViewById(R.id.textView2);
        titulo.setImageResource(mielemento.getTitulo());
        subtitulo.setText(mielemento.getSubtitulo());

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return(item);
    }
}

