package com.example.misegundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText note1;
    private EditText note2;
    private EditText note3;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = (EditText) findViewById(R.id.nota1);
        note2 = (EditText) findViewById(R.id.nota2);
        note3 = (EditText) findViewById(R.id.nota3);
        resultado = (TextView) findViewById(R.id.resultado_Evaluacion);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    //Evaluar la nota
    public void evaluarNotas(View view){
        String nota1 = note1.getText().toString();
        String nota2 = note2.getText().toString();
        String nota3 = note3.getText().toString();
        String evaluacion;

        int notaMatem, notaQuim, notaFis;
        notaMatem = Integer.parseInt(nota1);
        notaQuim = Integer.parseInt(nota2);
        notaFis = Integer.parseInt(nota3);

        if(notaMatem <= 0 || notaMatem > 10 || notaQuim <= 0 || notaQuim > 10 || notaFis <= 0 || notaFis > 10){
            evaluacion = "Datos incorrectos";
            resultado.setText(evaluacion);
        }
        else{
            if((notaMatem < 4) || (notaFis < 4) || (notaQuim < 4)){
                evaluacion = "Desaprobado";
            }
            else{
                int promedio = (notaMatem + notaQuim + notaFis) / 3;
                if(promedio >= 7){
                    evaluacion = "Aprobado";
                }
                else evaluacion = "Desaprobado";
            }
        }

        resultado.setText(evaluacion);
    }

}
