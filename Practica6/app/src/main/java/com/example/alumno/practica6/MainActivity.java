package com.example.alumno.practica6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txv;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView)findViewById(R.id.textView4);
        i = new Intent(this, Main2Activity.class);
    }
    public void Alta(View v){

    }
    public void Modificar(View v){
        if(v.getId()==R.id.button2) {
            String s = txv.getText().toString();
            String partido[] = s.split(" ");
            i.putExtra("p1", partido[0]);
            i.putExtra("p2", partido[1]);
        }
        i.putExtra("id", v.getId());
        startActivityForResult(i,SECONDARY_ACTIVITY_TAG);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String respuesta;
        String respuesta2;

        // Como solo lanzamos una actividad, requestCode siempre será
        // SECONDARY_ACTIVITY_TAG. No hace falta que lo comprobemos.

        if (resultCode==RESULT_OK) {
            // Tenemos una respuesta. La recuperamos del intent que nos
            // ha llegado desde la segunda actividad.
            respuesta = data.getStringExtra("nom");
            respuesta2 = data.getStringExtra("apellido");
            txv.setText(respuesta +" "+ respuesta2);
        }else{

            Toast toast = Toast.makeText(this,"Has salido de la actividad sin pulsar el boton Aceptar",Toast.LENGTH_SHORT);
            toast.show();
        }

    } // onActivityResult
    /**
     * "Etiqueta" que usamos para llamar a la segunda actividad, y que
     * esperamos recibir como primer parámetro de vuelta en el
     * callback onActivityResult().
     */
    private static final int SECONDARY_ACTIVITY_TAG = 1;
}
