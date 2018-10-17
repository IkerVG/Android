package com.example.alumno.practica5;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Articulo>list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add(new Articulo("pan",false));
        list.add(new Articulo("queso",false));
        list.add(new Articulo("tomate",false));
        list.add(new Articulo("lechuga",false));
        list.add(new Articulo("chorizo",false));
       Adapter adaptador = new Adapter(this,list);
        ListView listView = (ListView)findViewById(R.id.lista);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });
    }
}
