package com.example.solemne2stgo_ignaciocodelia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private RatingBar calificar;
    private Insumos in = new Insumos(); // Instancia del onj Insumos.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        // Recibo mis extras.

        Bundle bun = getIntent().getExtras(); //Recibo el intent con los valores del bundle.
        String[] listado = bun.getStringArray("insumos"); // recibo a partir de su referencia.

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);



    }
  // metodo para calcular horas
    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString(); // Obtengo la selección en una variable.
        int resultado = 0;

        for (int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(in.getInsumos()[i])) // Pregunto por la seleccion del spinerr.
            {
                //resultado = in.getPrecios()[i]; //Obtengo los precios.
                resultado = in.anadirAdicional(in.getPrecios()[i], 350); // regla de negocios.
                 calificar.setRating(i+1); //Pinto Estrellas
                break;
            }
        }

        result.setText("La Opción es: " + opcion + "\nSu precio es: " + resultado);
    }
}