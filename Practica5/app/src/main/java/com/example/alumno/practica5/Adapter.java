package com.example.alumno.practica5;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Articulo> {
    Activity contexto;
    Adapter(Activity contexto, ArrayList<Articulo> datos){
        super(contexto,R.layout.lstvw,datos);
        this.contexto=contexto;

    }
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.lstvw, null);

        //Mediante getItem cargamos cada uno de los objetos del array
        Articulo mielemento=getItem(position);

        TextView texto=(TextView)item.findViewById(R.id.textView2);
        texto.setText(mielemento.getNombre());



        // Devolvemos la Vista (nueva o reutilizada) que dibuja la opcion
        return(item);
    }
    if (datos.get(position).isComprado()) {
        nombreArticulo.setPaintFlags(nombreArticulo.getPaintFlags() |
                Paint.STRIKE_THRU_TEXT_FLAG);
        nombreArticulo.setTextColor(Color.parseColor("#00FF00"));
    } else{
        nombreArticulo.setPaintFlags(nombreArticulo.getPaintFlags()
                & ~Paint.STRIKE_THRU_TEXT_FLAG);
        nombreArticulo.setTextColor(Color.parseColor("#FF0000"));
    }


}
