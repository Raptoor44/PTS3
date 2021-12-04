package com.example.pts3;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.pts3.aliment.Gestion_UnAliment;
import com.example.pts3.model.Aliment;
import com.example.pts3.model.Conteneurs;
import com.example.pts3.model.Custom_list_aliment;
import com.example.pts3.model.List_conteneurs;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;

public class Frigo extends AppCompatActivity {

    private ImageButton retour;
    private Button ajouter_produit;

    private Custom_list_aliment adapter;
    private Custom_list_aliment adapter_filter;

    private EditText etSearch;
    private ListView listView;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frigo);

        etSearch = (EditText) findViewById(R.id.id_activity_frigo_searchView);
        listView = findViewById(R.id.id_activity_frigo_listview_aliment);


        this.ajouter_produit = findViewById(R.id.id_activity_frigo_ajouter_produit);
        this.ajouter_produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ajouter_a_frigo_general.class);
                startActivity(intent);
                finish();
            }
        });


        Conteneurs conteneur_ = null;

        for (Conteneurs conteneur : List_conteneurs.getConteneursList()) {
            if (conteneur.isIsvalid() == true) {
                conteneur_ = conteneur;
            }


        }
        adapter = new Custom_list_aliment(this.getApplicationContext(), conteneur_.getAliments());

        listView.setAdapter(adapter);


        Conteneurs finalConteneur_ = conteneur_;
        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                for (Aliment aliment : finalConteneur_.getAliments()) {


                    Log.e("position layout ", position + "");
                    Log.e("id aliment ", aliment.getId() + "");

                    if (position == aliment.getId()) {
                        aliment.setIsvalide(true);
                    }

                    Intent intent = new Intent(getApplicationContext(), Gestion_UnAliment.class);
                    startActivity(intent);
                    finish();

                }

            }
        });
*/
        _aliment();


        this.retour = findViewById(R.id.id_activity_frigo_boutton_retour);

        this.retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mes_conteneurs.class);
                startActivity(intent);
                finish();
            }
        });


// Add Text Change Listener to EditText
        etSearch.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter

                Log.e("Test listiner", "AAAAAAAAAAAAAAA");


                adapter.getFilter().filter(s.toString());


                listView.setAdapter(adapter);


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void _aliment() {
        Aliment aliment = new Aliment("test", 50, "unite", Calendar.getInstance().getTime());

        for (Conteneurs conteneur : List_conteneurs.getConteneursList()) {
            if (conteneur.isIsvalid() == true) {

                aliment.setId(conteneur.getStatic_id_aliment());
                conteneur.setStatic_id_aliment(conteneur.getStatic_id_aliment() + 1);
                conteneur.getAliments().add(aliment);

            }
        }
    }


}