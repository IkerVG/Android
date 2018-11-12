package com.example.alumno.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Data> {

    Activity contexto;
    // Contructor del adaptador usando el contexto de la aplicacion actual

    Adapter(Activity contexto, ArrayList<Data> datos) {

        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.lstvw, datos);
        this.contexto = contexto;
    }
    // Metodo que dibuja la Vista de cada Opcion
// Se invoca cada vez que haya que mostrar un elemento de la lista.
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.lstvw, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        Data mielemento=getItem(position);

        ImageView titulo=(ImageView)item.findViewById(R.id.imageView3);
        TextView subtitulo = (TextView)item.findViewById(R.id.textView);
        TextView subtitulo2 = (TextView)item.findViewById(R.id.textView2);
        TextView subtitulo3 = (TextView)item.findViewById(R.id.textView3);
        TextView subtitulo4 = (TextView)item.findViewById(R.id.textView4);
        titulo.setImageResource(mielemento.getTitulo());
        subtitulo.setText(mielemento.getSubtitulo());
        subtitulo2.setText(mielemento.getSubtitulo2());
        subtitulo3.setText(mielemento.getSubtitulo3());
        subtitulo4.setText(mielemento.getSubtitulo4());

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return(item);
    }
}
