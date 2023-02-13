package com.example.sharedpreferencesejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
Autor: Juan Francisco Sánchez González
Fecha: 12/02/2023
Clase: Actividad principal que utiliza la clase SharedPreferences para almacenar los datos de los campos de
 texto. Cada vez que se inicia la aplicación coloca en los controles la última informnación ingresada. Se dispone
  de un botón para almacenar los datos y finalizar el programa.
*/

public class MainActivity extends AppCompatActivity {

    private Button boton;
    private EditText nombre;
    private EditText telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancia componentes de la interfaz
        boton = (Button) findViewById(R.id.button);
        nombre = (EditText) findViewById(R.id.editTextTextPersonName);
        telefono = (EditText) findViewById(R.id.editTextPhone);

        // Obtenemos las preferencias y se las asignamos a los controles
        SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
        nombre.setText(preferencias.getString("Nombre", ""));
        telefono.setText(preferencias.getString("Telefono", ""));

        // Listener botón
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardamos las preferencias y salimos del aplicativo
                SharedPreferences prefs =getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Nombre", nombre.getText().toString());
                editor.putString("Telefono", telefono.getText().toString());
                editor.commit();
                finish();
            }
        });
    }
}