package com.antoniaggo.mismascotas.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoniaggo.mismascotas.R;
import com.antoniaggo.mismascotas.adapter.MascotaAdaptador;
import com.antoniaggo.mismascotas.adapter.MascotaProfileAdaptador;
import com.antoniaggo.mismascotas.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private ArrayList<Mascota> photos = new ArrayList<>();
    private RecyclerView listaPhotos;

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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        // To make a circular ImageView
        CircularImageView circularImageView = v.findViewById(R.id.civ_pet);
        // Set Color
        // circularImageView.setCircleColor(Color.WHITE);
        // or with gradient
  /*      circularImageView.setCircleColorStart(Color.BLACK);
        circularImageView.setCircleColorEnd(Color.RED);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
*/
        // Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.CYAN);
       // or with gradient
       /* circularImageView.setBorderColorStart(Color.BLACK);
        circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
*/
        // Add Shadow with default param
//        circularImageView.setShadowEnable(true);
        // or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.WHITE);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);



        // Nos hemos traido el RecyclerView del Activity Main
        listaPhotos = v.findViewById(R.id.recyclerViewProfile);

/*
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPhotos.setLayoutManager(llm);
*/

        // Le pasamos el número de columnas del Grid
        RecyclerView.LayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaPhotos.setLayoutManager(glm);

        inicializarListaPhotos();
        inicializarAdaptador();
        return v;

    }

    public void inicializarListaPhotos(){
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",1));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",2));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",3));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",4));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",5));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",6));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",7));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",8));
        photos.add(new Mascota(R.drawable.icons8_fish_96,"Fish",9));

    }

    // Crear un objeto de MascotaAdaptador pasarle nuestra lista para que mascotaAdaptador pueda hacer lo que tenemos definido
    public void inicializarAdaptador(){
        MascotaProfileAdaptador adapter = new MascotaProfileAdaptador(photos,getActivity());
        listaPhotos.setAdapter(adapter);
    }
}