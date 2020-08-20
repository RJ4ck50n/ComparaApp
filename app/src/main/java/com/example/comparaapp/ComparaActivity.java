package com.example.comparaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ComparaActivity extends AppCompatActivity {
    Spinner spinnerArroz;
    Spinner spinnerAzucar;
    Spinner spinnerAceite;
    Spinner spinnerLeche;
    String itemselected;
    DatabaseReference mrootReference;
    ArrayList listaprodArroz;
    ArrayList listaprodAzucar;
    ArrayList listaprodAceite;
    ArrayList listaprodLeche;
    Button btnComparacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compara);

        mrootReference=FirebaseDatabase.getInstance().getReference();
        spinnerArroz=findViewById(R.id.spinnerPrueba);
        spinnerAzucar=findViewById(R.id.spinnerAzucar);
        spinnerAceite=findViewById(R.id.spinnerAceite);
        spinnerLeche=findViewById(R.id.spinnerLeche);

        listaprodArroz=new ArrayList();
        listaprodAzucar=new ArrayList();
        listaprodAceite=new ArrayList();
        listaprodLeche=new ArrayList();
        btnComparacion=(Button)findViewById(R.id.btn_irComparacion);

        mrootReference.child("Arroz").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaprodArroz.clear();
                listaprodArroz.add("Seleccione un Producto");
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Producto unprod=snapshot.getValue(Producto.class);
                    String marca=unprod.getMarca();
                    String mtipo=unprod.getTipo();
                    String peso=unprod.getPeso();
                    String conjunto= mtipo + " "+ marca+ " "+peso;
                    listaprodArroz.add(conjunto);
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(ComparaActivity.this,android.R.layout.simple_dropdown_item_1line,listaprodArroz);
                spinnerArroz.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        spinnerArroz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemselected=parent.getItemAtPosition(position).toString();
                ImageView imgView = (ImageView)findViewById(R.id.imageViewArroz);
                if(itemselected.equals("Arroz Extra COSTEÑO 5 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.arrozextracosteno5kg));
                }if(itemselected.equals("Arroz Extra COSTEÑO 750 gr")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.arrozextracosteno750g));
                }else if(itemselected.equals("Arroz Superior COSTEÑO 750 gr")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.arrozsuperiorcosteno750g));
                }else if(itemselected.equals("Arroz Superior COSTEÑO 5 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.arrozsuperiorcosteno5kg));}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        mrootReference.child("Azucar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaprodAzucar.clear();
                listaprodAzucar.add("Seleccione un Producto");
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Producto unprod=snapshot.getValue(Producto.class);
                    String marca=unprod.getMarca();
                    String mtipo=unprod.getTipo();
                    String peso=unprod.getPeso();
                    String conjunto= mtipo + " "+ marca+ " "+peso;
                    listaprodAzucar.add(conjunto);
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(ComparaActivity.this,android.R.layout.simple_dropdown_item_1line,listaprodAzucar);
                spinnerAzucar.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mrootReference.child("Leche").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaprodLeche.clear();
                listaprodLeche.add("Seleccione un Producto");
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Producto unprod=snapshot.getValue(Producto.class);
                    String marca=unprod.getMarca();
                    String mtipo=unprod.getTipo();
                    String peso=unprod.getPeso();
                    String conjunto= mtipo + " "+ marca+ " "+peso;
                    listaprodLeche.add(conjunto);
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(ComparaActivity.this,android.R.layout.simple_dropdown_item_1line,listaprodLeche);
                spinnerLeche.setAdapter(arrayAdapter);}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        btnComparacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(v.getContext(), Comparacionproductos.class);
                CheckBox checkMetro2= (CheckBox) findViewById(R.id.checkboxMetro);
                String valor = spinnerArroz.getSelectedItem().toString();
                inte.putExtra("arroz",valor);
                startActivityForResult(inte,0);
            }

        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Establecer activity por defecto->Compara
        bottomNavigationView.setSelectedItemId(R.id.Compara);

        //Realizar el llamado del Item seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Compara:
                        return true;

                    case R.id.Inicio:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.MiPerfil:
                        startActivity(new Intent(getApplicationContext()
                                ,MiPerfil2.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }



}