package com.antoniaggo.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.textfield.TextInputEditText;


public class Formulario_Activity extends AppCompatActivity {


    AppCompatButton btnEnviarComentario;
    TextInputEditText tietNombreFormulario;
    TextInputEditText tietEmailFormulario;
    TextInputEditText tietMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        btnEnviarComentario = (AppCompatButton) findViewById(R.id.btn_enviar_comentario);
        tietNombreFormulario = (TextInputEditText) findViewById(R.id.tietNombreFormulario);
        tietEmailFormulario = (TextInputEditText) findViewById(R.id.tietEmailFormulario);
        tietMensaje = (TextInputEditText) findViewById(R.id.tietMensaje);

        // handle submit button to preview the entered data
        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set the entered data to text preview
                // tvTextPreview.setText("You Entered : " + mEditText.getText().toString());
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL , tietEmailFormulario.getText().toString());
               
                i.putExtra(Intent.EXTRA_SUBJECT, tietNombreFormulario.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT , tietMensaje.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Formulario_Activity.this, "No email client configured. Please check.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}