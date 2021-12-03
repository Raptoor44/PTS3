package com.example.pts3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {

    private ImageButton fleche_retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        this.fleche_retour = findViewById(R.id.id_activity_notification_fleche_retour);

        this.fleche_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Parametres.class);
                startActivity(intent);
            }
        });
    }
}