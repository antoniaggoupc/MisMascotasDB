package com.antoniaggo.mismascotas;


import android.os.Bundle;

import com.antoniaggo.mismascotas.adapter.MascotaAdaptador;
import com.antoniaggo.mismascotas.pojo.Mascota;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar);
        // Nos aseguramos de que la configuración que hemos aplicado en AndroidManifest.xml
        // a la activity activity_segundo.xml funcione correctamente
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = findViewById(R.id.recyclerViewMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    // Crear un objeto de contactoAdaptador pasarle nuestra lista para que contactoAdaptador pueda hacer lo que tenemos definido
    public void inicializarAdaptador(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adapter);
    }


    public void inicializarListaMascotas(){
        mascotas.add(new Mascota(R.drawable.icons8_fish_96,"Fish",2));
        mascotas.add(new Mascota(R.drawable.icons8_hamster_96,"Hamster", 1));
        mascotas.add(new Mascota(R.drawable.icons8_kissing_cat_48,"Catty", 7));
        mascotas.add(new Mascota(R.drawable.icons8_parrot_96,"Parrot", 5));
        mascotas.add(new Mascota(R.drawable.icons8_squirrel_96,"Squirrel", 4));

    }
}