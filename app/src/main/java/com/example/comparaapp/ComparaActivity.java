package com.example.comparaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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
        final Bundle miBundle=this.getIntent().getExtras();


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

        mrootReference.child("tipoAzucar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaprodAzucar.clear();
                listaprodAzucar.add("Seleccione un Producto");
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Producto unprod=snapshot.getValue(Producto.class);
                    String prod=unprod.getProducto();
                    String mtipo=unprod.getTipo();
                    String peso=unprod.getPeso();
                    String conjunto= prod + " "+ mtipo+ " "+peso;
                    listaprodAzucar.add(conjunto);
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(ComparaActivity.this,android.R.layout.simple_dropdown_item_1line,listaprodAzucar);
                spinnerAzucar.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        spinnerAzucar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemselected=parent.getItemAtPosition(position).toString();
                ImageView imgView = (ImageView)findViewById(R.id.imageAzucar);
                if(itemselected.equals("Azucar Rubia 1 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.azucarrubiametro1kg));
                }if(itemselected.equals("Azucar Rubia 2 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.azucarrubiametro2kg));
                }else if(itemselected.equals("Azucar Rubia 5 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.azucarrubiametro5kg));
                }else if(itemselected.equals("Azucar Blanca 1 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.azucarblancawong1kg));}
                else if(itemselected.equals("Azucar Blanca 2 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.azucarblancawong2kg));}
                else if(itemselected.equals("Azucar Blanca 5 KG")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.azucarblancawong5kg));}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        mrootReference.child("Aceite").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaprodAceite.clear();
                listaprodAceite.add("Seleccione un Producto");
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Producto unprod=snapshot.getValue(Producto.class);
                    String marca=unprod.getMarca();
                    String mtipo=unprod.getTipo();
                    String peso=unprod.getPeso();
                    String conjunto= mtipo + " "+ marca+ " "+peso;
                    listaprodAceite.add(conjunto);
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(ComparaActivity.this,android.R.layout.simple_dropdown_item_1line,listaprodAceite);
                spinnerAceite.setAdapter(arrayAdapter);}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        mrootReference.child("Leche").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaprodLeche.clear();
                listaprodLeche.add("Seleccione un Producto");
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Producto unprod=snapshot.getValue(Producto.class);
                    String marca=unprod.getMarca();
                    String por=unprod.getProducto();
                    String peso=unprod.getPeso();
                    Integer unida=unprod.getUnidades();
                    String conjunto= por + " "+ marca+ " "+peso+" "+unida+" unidades";
                    listaprodLeche.add(conjunto);
                }
                ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(ComparaActivity.this,android.R.layout.simple_dropdown_item_1line,listaprodLeche);
                spinnerLeche.setAdapter(arrayAdapter);}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
        spinnerLeche.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemselected=parent.getItemAtPosition(position).toString();
                ImageView imgView = (ImageView)findViewById(R.id.imgLeche);
                if(itemselected.equals("Leche GLORIA 400 gr 6 unidades")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.lecheevaporadaglorialata400gr6un));
                }if(itemselected.equals("Leche GLORIA 170 gr 6 unidades")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.lecheevaporadaglorialata170gr6un));
                }else if(itemselected.equals("Leche GLORIA 400 gr 1 unidades")){imgView.setImageDrawable(ContextCompat.getDrawable(ComparaActivity.this,R.drawable.lecheevaporadaglorialata400gr));}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnComparacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(v.getContext(), Comparacionproductos.class);
                String super1=miBundle.getString("super1");
                String super2= miBundle.getString("super2");
                String valor = spinnerArroz.getSelectedItem().toString();
                String valor1 = spinnerAzucar.getSelectedItem().toString();
                String valor2 = spinnerAceite.getSelectedItem().toString();
                String valor3 = spinnerLeche.getSelectedItem().toString();
                inte.putExtra("super1",super1);
                inte.putExtra("super2",super2);
                inte.putExtra("arroz",valor);
                inte.putExtra("azucar",valor1);
                inte.putExtra("aceite",valor2);
                inte.putExtra("leche",valor3);
                startActivityForResult(inte,0);
            }

        });

    }



}