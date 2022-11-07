package com.antoniaggo.mismascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antoniaggo.mismascotas.R;
import com.antoniaggo.mismascotas.pojo.Mascota;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaProfileAdaptador extends RecyclerView.Adapter<MascotaProfileAdaptador.MascotaProfileViewHolder>{
    ArrayList<Mascota> mascotaPhotos;
    Activity activity;

    // Construye nuestra lista de contactos
    public MascotaProfileAdaptador(ArrayList<Mascota> mascotasPhotos, Activity activity) {
        this.mascotaPhotos = mascotasPhotos;
        this.activity = activity;
    }

    // Infla el layout y lo pasará al ViewHolder para que él obtenga los views
    @NonNull
    @Override
    public MascotaProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_pet_profile, parent, false);
        return new MascotaProfileViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MascotaProfileViewHolder mascotaViewHolder, int position) {
        // Obtiene el objeto en el que está iterando
        Mascota mascota = mascotaPhotos.get(position);
        // Setea la información
        mascotaViewHolder.img_foto_CV.setImageResource(mascota.getFoto());
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
        return mascotaPhotos.size();
    }

    public static class MascotaProfileViewHolder extends RecyclerView.ViewHolder {

        private androidx.appcompat.widget.AppCompatImageView img_foto_CV;
        private TextView likes_CV;
        private androidx.appcompat.widget.AppCompatImageView btn_like_CV;

        public MascotaProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            img_foto_CV = itemView.findViewById(R.id.img_foto_cv_pet);
            btn_like_CV = itemView.findViewById(R.id.img_bone_dog_color_cv_pet);
            likes_CV = itemView.findViewById(R.id.likes_cv_pet);
        }
    }
}
