package com.example.alumno.practica4;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
//https://youtu.be/a8ido7-rDus
public class MainActivity extends AppCompatActivity {
    final String[] deportes =new String[]{"Baloncesto","Fútbol","Motociclismo","Natación","Golf","Atletismo","Ping Pong"};
    final int [] imgs = new int[]{R.drawable.baloncesto,
                                  R.drawable.futbol,
                                  R.drawable.motociclismo,
                                  R.drawable.natacion,
                                  R.drawable.golf,
                                  R.drawable.atletismo,
                                  R.drawable.pingpong};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, deportes);

        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Has hecho clic en el '" + deportes[position] + "'", Toast.LENGTH_LONG).show();
            }
        });

        }
}
