package com.example.inmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmuebles.model.Inmueble;

import java.util.List;

/*
* Se crea la clase ListaInmuebleAdapter que hereda
* de ArrayAdapter de Inmueble (clase creada en el modelo)
* para poder mostrar los datos en el ListView de la vista
* */
public class ListaInmuebleAdapter extends ArrayAdapter<Inmueble> {
    private Context context; // Se crea un contexto
    private List<Inmueble> lista; // Se crea una lista de inmuebles
    private LayoutInflater li; // Se crea un inflador
    public ListaInmuebleAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater inflater) { // Constructor
        super(context, resource, objects);
        this.context = context; // Se asigna el contexto
        this.lista = objects; // Se asigna la lista
        this.li = inflater; // Se asigna el inflador
    }

    @NonNull // Se sobreescribe el método getDropDownView
    @Override // Se sobreescribe el método getView
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) { // Se obtiene la vista
        View view = convertView; // Se crea una vista

        if(view == null){ // Si la vista es nula
            view = li.inflate(R.layout.item, parent, false); // Se infla la vista
        }

        Inmueble inmueble = lista.get(position); // Se obtiene el inmueble de la lista

        ImageView foto = view.findViewById(R.id.foto); // Se obtiene la foto
        foto.setImageResource(inmueble.getFoto()); // Se le asigna la foto al inmueble

        TextView direccion = view.findViewById(R.id.direccion); // Se obtiene la direccion
        direccion.setText(inmueble.getDireccion()); // Se le asigna la direccion al inmueble

        TextView precio = view.findViewById(R.id.precio); // Se obtiene el precio
        precio.setText(String.valueOf(inmueble.getPrecio())); // Se le asigna el precio al inmueble

        return view; // Se retorna la vista
    }
}
