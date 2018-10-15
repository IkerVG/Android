package com.example.alumno.practica4;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {



    private ArrayList<DataItem> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignamos el objeto ListView con el id de la etiqueta ListView del
        //layout principal
        ListView listaOpciones = (ListView)findViewById(R.id.LstOpciones);
        // Creamos los objetos y los guardamos en un array
            datos.add(new DataItem(R.drawable.baloncesto, "Baloncesto"));
            datos.add(new DataItem(R.drawable.futbol, "Fútbol"));
            datos.add(new DataItem(R.drawable.motociclismo, "Motociclismo"));
            datos.add(new DataItem(R.drawable.natacion, "Baloncesto"));
            datos.add(new DataItem(R.drawable.golf, "Baloncesto"));
            datos.add(new DataItem(R.drawable.atletismo, "Baloncesto"));
            datos.add(new DataItem(R.drawable.pingpong, "Baloncesto"));
        // Usamos un adaptador para dibujar las opciones de la lista
        Adaptador adaptador = new Adaptador(this,datos);

        // Establecemos el adaptador del Listview
        listaOpciones.setAdapter(adaptador);

        // Definimos el evento setOnItemClick
       /* listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Si se hace clic sobre una opción mostramos un mensaje
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Has hecho clic en la '" + datos.get(position).getTitulo() + "'", Toast.LENGTH_LONG).show();
            }
        });*/
    }


}
