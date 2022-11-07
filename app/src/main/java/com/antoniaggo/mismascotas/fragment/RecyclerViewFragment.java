package com.antoniaggo.mismascotas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoniaggo.mismascotas.R;
import com.antoniaggo.mismascotas.adapter.MascotaAdaptador;
import com.antoniaggo.mismascotas.pojo.Mascota;
import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView listaMascotas;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // Equivalente al setContentView(R.layout.activity_main); de la clase MainActivity
        // Es decir, la forma en que asociamos un layout a una clase
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        // Nos hemos traido el RecyclerView del Activity Main
        listaMascotas = v.findViewById(R.id.recyclerViewMascotas);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
        return v;

    }

    public void inicializarListaMascotas(){
        mascotas.add(new Mascota(R.drawable.icons8_fish_96,"Fish",20));
        mascotas.add(new Mascota(R.drawable.icons8_hamster_96,"Hamster", 10));
        mascotas.add(new Mascota(R.drawable.icons8_kissing_cat_48,"Catty", 7));
        mascotas.add(new Mascota(R.drawable.icons8_parrot_96,"Parrot", 5));
        mascotas.add(new Mascota(R.drawable.icons8_squirrel_96,"Squirrel", 4));
        mascotas.add(new Mascota(R.drawable.icons8_fish_96,"Fish_2",2));
        mascotas.add(new Mascota(R.drawable.icons8_hamster_96,"Hamster_2", 7));
        mascotas.add(new Mascota(R.drawable.icons8_kissing_cat_48,"Catty_2", 3));
        mascotas.add(new Mascota(R.drawable.icons8_parrot_96,"Parrot_2", 25));
        mascotas.add(new Mascota(R.drawable.icons8_squirrel_96,"Squirrel_2", 12));

    }

    // Crear un objeto de MascotaAdaptador pasarle nuestra lista para que mascotaAdaptador pueda hacer lo que tenemos definido
    public void inicializarAdaptador(){
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adapter);
    }

}