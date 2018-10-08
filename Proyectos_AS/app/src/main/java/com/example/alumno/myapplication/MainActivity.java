package com.example.alumno.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("SetTextI18n")
    public void Button (View v){
        TextView mostrar = (TextView)findViewById(R.id.editText);
        TextView texto = (TextView)findViewById(R.id.textView);
        Toast popup = Toast.makeText(getApplicationContext(),"Campo de texto vacío", Toast.LENGTH_SHORT);
        Toast pupup1 = Toast.makeText(getApplicationContext(),"No se pueden introducir letras ni caracteres especiales", Toast.LENGTH_SHORT);
        try {
            if (!(mostrar.getText().length() <= 0)) {
                RadioButton rb = (RadioButton) findViewById(R.id.radioButton);
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
                float num;
                DecimalFormat dosdecimales = new DecimalFormat("#.00");
                num = Float.parseFloat(mostrar.getText().toString());
                if (rb.isChecked()) {
                    texto.setText("Millas son "+Float.toString(Float.parseFloat(dosdecimales.format(num/0.6214)))+" Kms");
                } else {
                    texto.setText("Kms son "+Float.toString(Float.parseFloat(dosdecimales.format(num*0.6214)))+" Millas");
                }

            } else {

                popup.show();
            }
        }catch (Exception e){
            pupup1.show();
        }

    }

}
