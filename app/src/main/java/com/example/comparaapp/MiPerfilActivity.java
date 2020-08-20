package com.example.comparaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MiPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Establecer activity por defecto->Mi Perfil
        bottomNavigationView.setSelectedItemId(R.id.MiPerfil);

        //Realizar el llamado del Item seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Compara:
                        startActivity(new Intent(getApplicationContext(), Supermercados.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Inicio:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.MiPerfil:
                        return true;
                }
                return false;
            }
        });
    }

    /* //Guardar el Proveedor y el usuario autenticado
    val prefs =
            getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
    // Guardar una cadena de texto
        prefs.putString("email", email)
            prefs.putString("provider", provider)
            prefs.apply()

     */
}