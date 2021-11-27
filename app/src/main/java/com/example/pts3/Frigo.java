package com.example.pts3;

import static com.example.pts3.model.List_conteneurs.conteneursList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.pts3.aliment.Gestion_UnAliment;
import com.example.pts3.model.Aliment;
import com.example.pts3.model.Conteneurs;
import com.example.pts3.model.Custom_list_aliment;
import com.example.pts3.model.Custom_list_conteneurs;
import com.example.pts3.model.List_conteneurs;

public class Frigo extends AppCompatActivity {

    private ImageButton retour;
    private Button ajouter_produit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frigo);


        this.ajouter_produit = findViewById(R.id.id_activity_frigo_ajouter_produit);
        this.ajouter_produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ajouter_a_frigo_general.class);
                startActivity(intent);
                finish();
            }
        });


        final ListView listView = (ListView) findViewById(R.id.id_activity_frigo_listview_aliment);


        Conteneurs conteneur_ = null;

        for (Conteneurs conteneur : List_conteneurs.getConteneursList()) {
            if (conteneur.isIsvalid() == true) {
                conteneur_ = conteneur;
            }


        }
        Custom_list_aliment adapter = new Custom_list_aliment(this.getApplicationContext(), conteneur_.getAliments());

        listView.setAdapter(adapter);

        Conteneurs finalConteneur_ = conteneur_;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                for (Aliment aliment : finalConteneur_.getAliments()) {


                    Log.e("position layout " , position+ "");
                    Log.e("id aliment ", aliment.getId()+"");

                    if (position == aliment.getId()) {
                        aliment.setIsvalide(true);
                    }

                    Intent intent = new Intent(getApplicationContext(), Gestion_UnAliment.class);
                    startActivity(intent);
                    finish();

                }

            }
        });


        this.retour = findViewById(R.id.id_activity_frigo_boutton_retour);

        this.retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mes_conteneurs.class);
                startActivity(intent);
                finish();
            }
        });
    }
}