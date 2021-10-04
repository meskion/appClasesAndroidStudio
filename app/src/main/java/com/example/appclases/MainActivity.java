package com.example.appclases;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText acceso, interf, web, empresa;
    TextView calif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acceso = findViewById(R.id.inputAcceso);
        interf = findViewById(R.id.inputInterfaces);
        web = findViewById(R.id.inputWeb);
        empresa = findViewById(R.id.inputEmpresa);

        calif = findViewById(R.id.calificacion);


    }


    public void evaluar(View vista) {
         String[] strNotas = {acceso.getText().toString(),
                 interf.getText().toString(),
                 web.getText().toString(),
                 empresa.getText().toString()};

        List<Double> notas = new ArrayList<>();

        for (String nota : strNotas) {
            if (nota.isEmpty()) {
                Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
                return;
            } else{
                notas.add(Double.parseDouble(nota));
            }
        }


        int size =notas.size();
        Double result = 0.0;
        for (Double nota : notas) {
            if (nota > 10){
                Toast.makeText(this,"Valor invalido de calificación", Toast.LENGTH_SHORT).show();
                return;
            }
            result = result + nota / size;
        }
        if (result >= 5){
            calif.setText(R.string.aprobado);
            calif.setTextColor(Color.GREEN);
        } else{
            calif.setText(R.string.suspenso);
            calif.setTextColor(Color.RED);
        }

    }
}