package com.antoniaggo.mismascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antoniaggo.mismascotas.pojo.Mascota;
import com.antoniaggo.mismascotas.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    // Construye nuestra lista de contactos
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    // Infla el layout y lo pasará al ViewHolder para que él obtenga los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        // Obtiene el objeto en el que está iterando
        Mascota mascota = mascotas.get(position);
        // Setea la información
        mascotaViewHolder.img_foto_CV.setImageResource(mascota.getFoto());
        mascotaViewHolder.pet_nombre_CV.setText(mascota.getNombre());
        mascotaViewHolder.likes_CV.setText(Integer.toString(mascota.getLikes()));;

        // TODO better visual aspect
        mascotaViewHolder.btn_like_CV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String likes = mascotaViewHolder.likes_CV.getText().toString();
                int numLikes = Integer.parseInt(likes);

                if(!mascota.isButtonClicked()) {
                    numLikes += 1;
                    mascotaViewHolder.btn_like_CV.setBackground(view.getResources().getDrawable(R.drawable.icons8_dog_bone_96_color));
                    mascota.setButtonClicked(true);
                } else {
                    numLikes -= 1;
                    mascotaViewHolder.btn_like_CV.setBackground(view.getResources().getDrawable(R.drawable.icons8_dog_bone_24));
                    mascota.setButtonClicked(false);
                }

                mascotaViewHolder.likes_CV.setText(Integer.toString(numLikes));

            }
        });

    }

    // Devuelve la cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private androidx.appcompat.widget.AppCompatImageView img_foto_CV;
        private TextView pet_nombre_CV;
        private TextView likes_CV;
        private androidx.appcompat.widget.AppCompatImageView btn_like_CV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            img_foto_CV = itemView.findViewById(R.id.img_foto_CV);
            btn_like_CV = itemView.findViewById(R.id.btn_like_CV);
            pet_nombre_CV = itemView.findViewById(R.id.pet_nombre_CV);
            likes_CV = itemView.findViewById(R.id.likes_CV);
        }
    }
}
