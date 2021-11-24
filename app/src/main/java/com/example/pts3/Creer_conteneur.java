package com.example.pts3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pts3.model.Conteneurs;
import com.example.pts3.model.List_conteneurs;
import com.google.android.material.textfield.TextInputEditText;

public class Creer_conteneur extends AppCompatActivity {

    private TextInputEditText text;
    private Button ajouter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_conteneur);



        this.ajouter = findViewById(R.id.id_activity_creer_conteneur_bouton_creer_conteneur);
        this.text = findViewById(R.id.id_activity_creer_conteneur_text_input);

        this.ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titre_conteneur;
                titre_conteneur = text.getText().toString();

                List_conteneurs.getConteneursList().add(new Conteneurs(titre_conteneur));


                Intent intent = new Intent(getApplicationContext(), Mes_conteneurs.class);
                startActivity(intent);

            }
        });



    }
}