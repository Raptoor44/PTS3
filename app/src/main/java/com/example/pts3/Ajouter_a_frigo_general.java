package com.example.pts3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ajouter_a_frigo_general extends AppCompatActivity {


    private Button ajouter_produit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_afrigo_general);

        this.ajouter_produit = findViewById(R.id.id_activity_ajouter_afrigo_general_AJOUT_MANUEL);

        this.ajouter_produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ajouter_a_frigo_manuel.class);
                startActivity(intent);
            }
        });
    }
}