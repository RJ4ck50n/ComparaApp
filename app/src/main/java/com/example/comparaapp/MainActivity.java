package com.example.comparaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Establecer activity por defecto
        bottomNavigationView.setSelectedItemId(R.id.Inicio);

        //Realizar el llamado del Item seleccionado: ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Compara:
                        startActivity(new Intent(getApplicationContext()
                                ,ComparaActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Inicio:
                        return true;

                    case R.id.MiPerfil:
                        startActivity(new Intent(getApplicationContext()
                                ,MiPerfilActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}