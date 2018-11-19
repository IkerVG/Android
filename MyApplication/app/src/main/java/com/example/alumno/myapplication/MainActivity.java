package com.example.alumno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.example.alumno.myapplication.R.raw.peces;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Data> datos = new ArrayList<>();
    private Spinner spinner;
    InputStream is;
    BufferedReader bf;
    Adapter adaptador;
    ListView listaOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         spinner = (Spinner)findViewById(R.id.spinner);
         listaOpciones = (ListView)findViewById(R.id.lstvw);
        // Creamos los objetos y los guardamos en un array

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                datos.clear();
                if(position == 0){
                    peces();
                }else if(position == 1){
                    algas();
                }
                adaptador = new Adapter(MainActivity.this,datos);
                listaOpciones.setAdapter(adaptador);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("imagen",datos.get(position).getTitulo());
                startActivity(intent);
            }
        });
    }

    public void peces(){
        try {
                is = getResources().openRawResource(R.raw.peces);
                bf = new BufferedReader(new InputStreamReader(is));
                String linea;
                int i,bab = 0;
                while ( (linea = bf.readLine())!= null) {
                    String words[] = linea.split(",");
                    i = getResources().getIdentifier(words[0],"drawable",getPackageName());
                    if(bab == 0 ){ //La existencia de esta condición se debe a que sin ella la imagen de la babosa no la introduce
                    i = R.drawable.babosa;// no se donde puede estar el error, si lo encuentras, dímelo por favor.
                    bab++;// Como la babosa es la primera linea, lo he dejado así en plan chapuza.
                    }
                    datos.add(new Data(i, words[1], words[2], words[3], words[4]));
                }

        }catch (Exception e){}
    }
    public void algas(){
        try {
            is = getResources().openRawResource(R.raw.algaseinvertebrados);
            bf = new BufferedReader(new InputStreamReader(is));
            String linea;
            int i;
            while ( (linea = bf.readLine())!= null) {
                String words[] = linea.split(",");
                i = getResources().getIdentifier(words[0],"drawable",getPackageName());
                datos.add(new Data(i, words[1], words[3], words[4], words[5]));
            }

        }catch (Exception e){}
    }
}
