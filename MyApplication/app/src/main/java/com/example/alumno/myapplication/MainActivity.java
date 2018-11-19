package com.example.alumno.myapplication;

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
               peces(position);

                listaOpciones.setAdapter(adaptador);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void peces(int position){
        try {
            if(position==0){
                is = getResources().openRawResource(R.raw.peces);
            }else if(position == 1){
                is = getResources().openRawResource(R.raw.algaseinvertebrados);
            }

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
            adaptador = new Adapter(this,datos);
        }catch (Exception e){}
    }
}
