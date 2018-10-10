package com.example.alumno.ejercicioclase1;

/**
 * Created by usuario on 04/10/2016.
 */


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorOpciones extends ArrayAdapter<Opcion> {

        Activity contexto;
        // Contructor del adaptador usando el contexto de la aplicacion actual

        AdaptadorOpciones(Activity contexto, Opcion[] datos) {

        // Llamamos al constructor de la clase superior
        //se le pasa el xml que genera la fila y el array de objetos
        super(contexto, R.layout.listitem_opcion, datos);
        this.contexto = contexto;
        }
// Metodo que dibuja la Vista de cada Opcion
// Se invoca cada vez que haya que mostrar un elemento de la lista.
public View getView(int position, View convertView, ViewGroup parent)
        {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.listitem_opcion, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        Opcion mielemento=getItem(position);

        TextView titulo=(TextView)item.findViewById(R.id.LblTitulo);
        TextView subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        titulo.setText(mielemento.getTitulo());
        subtitulo.setText(mielemento.getSubtitulo());

        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return(item);
        }
        }
