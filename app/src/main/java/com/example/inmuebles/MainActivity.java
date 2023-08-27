package com.example.inmuebles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.inmuebles.model.Inmueble;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Inmueble> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        generarVista();
    }

    public void generarVista(){
        ArrayAdapter<Inmueble> adapter = new ListaInmuebleAdapter(this, R.layout.item, lista, getLayoutInflater());
        ListView listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(adapter);
    }

    public void cargarDatos(){
        lista.add(new Inmueble(R.drawable.foto1, "Calle 123", 1000));
        lista.add(new Inmueble(R.drawable.foto2, "Calle 456", 2000));
        lista.add(new Inmueble(R.drawable.foto3, "Calle 789", 3000));
    }
}