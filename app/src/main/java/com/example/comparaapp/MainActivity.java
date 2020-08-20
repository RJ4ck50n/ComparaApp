package com.example.comparaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Button btn_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_inicio = findViewById(R.id.btn_Inicio);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Establecer activity por defecto
        bottomNavigationView.setSelectedItemId(R.id.Inicio);

        //Realizar el llamado del Item seleccionado: ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Inicio:
                        return true;

                    case R.id.Compara:
                        startActivity(new Intent(getApplicationContext()
                                , ComparaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.MiPerfil:
                        startActivity(new Intent(getApplicationContext()
                                , MiPerfil2.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ComparaActivity.class));
            }
        });

    }








}