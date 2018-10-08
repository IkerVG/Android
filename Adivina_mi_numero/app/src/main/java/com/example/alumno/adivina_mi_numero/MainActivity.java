package com.example.alumno.adivina_mi_numero;

import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    static int num = (int) (Math.random()*100);

    public void button(View view) {
        TextView texto = (TextView)findViewById(R.id.textView0);
        TextView adivina = (TextView)findViewById(R.id.editText2);
        int numadivina = Integer.parseInt(adivina.getText().toString());
        if(num==numadivina){
            texto.setText("¡¡HAS ACERTADO!!");
        }else if(num<numadivina){
            texto.setText("¿"+numadivina+"? "+"Uy! El número que he pensado es menor");
        }else if(num>numadivina){
            texto.setText("¿"+numadivina+"? "+"Uy! El número que he pensado es mayor");
        }
    }
}
