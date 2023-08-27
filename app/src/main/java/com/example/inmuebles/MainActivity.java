package com.example.inmuebles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.inmuebles.model.Inmueble;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Inmueble> lista = new ArrayList<>(); // Se crea una lista de inmuebles

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        generarVista();
    }

    public void generarVista(){
        ArrayAdapter<Inmueble> adapter = new ListaInmuebleAdapter(this, R.layout.item, lista, getLayoutInflater()); // Se crea un adaptador de tipo ListaInmuebleAdapter y se le pasa la lista de inmuebles y el inflador
        ListView listView = (ListView) findViewById(R.id.lista); // Se obtiene el ListView de la vista por su id y se castea a ListView para poder asignarle el adaptador
        listView.setAdapter(adapter); // Se le asigna el adaptador al ListView para que pueda mostrar los datos
    }

    public void cargarDatos(){ // Se cargan los datos de los inmuebles
        lista.add(new Inmueble(R.drawable.foto1, "Calle 123", 1000));
        lista.add(new Inmueble(R.drawable.foto2, "Calle 456", 2000));
        lista.add(new Inmueble(R.drawable.foto3, "Calle 789", 3000));
    }
}