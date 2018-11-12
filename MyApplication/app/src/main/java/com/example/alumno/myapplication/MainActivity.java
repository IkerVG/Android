package com.example.alumno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.example.alumno.myapplication.R.raw.peces;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Data> datos = new ArrayList<>();
    private Spinner spinner = (Spinner)findViewById(R.id.spinner);
    InputStream is;
    BufferedReader bf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaOpciones = (ListView)findViewById(R.id.lstvw);
        // Creamos los objetos y los guardamos en un array
        int seleccionado = spinner.getSelectedItemPosition();


               asdf();

            Adapter adaptador = new Adapter(this,datos);
            listaOpciones.setAdapter(adaptador);

       /* datos.add(new DataItem(R.drawable.futbol, "Fútbol"));
        datos.add(new DataItem(R.drawable.motociclismo, "Motociclismo"));
        datos.add(new DataItem(R.drawable.natacion, "Baloncesto"));
        datos.add(new DataItem(R.drawable.golf, "Baloncesto"));
        datos.add(new DataItem(R.drawable.atletismo, "Baloncesto"));
        datos.add(new DataItem(R.drawable.pingpong, "Baloncesto"));
        // Usamos un adaptador para dibujar las opciones de la lista*/


    }
    public void asdf(){
        try {
        is = getResources().openRawResource(R.raw.peces);
        bf = new BufferedReader(new InputStreamReader(is));
        String linea;
        while ( (linea = bf.readLine())!= null) {
            String words[] = linea.split(",");
            datos.add(new Data(R.drawable.babosa, words[1], words[2], words[3], words[4]));

        }
        }catch (Exception e){}
    }
}
