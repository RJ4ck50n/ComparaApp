package com.example.comparaapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Supermercados extends AppCompatActivity {
    Button btnIrComparar;
    TextView textoPrueba;
    String arroz;
    String valor;
    ImageView logPlaza;
    Integer valid;
    CheckBox checkMetro;
    CheckBox checkPlaza;
    CheckBox checkTottus;
    CheckBox checkWong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruab);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        valid=4;

        checkMetro=(CheckBox) findViewById(R.id.checkboxMetro);
        checkPlaza=(CheckBox)findViewById(R.id.checkboxPlaza);
        checkTottus=(CheckBox)findViewById(R.id.checkboxTottus);
        checkWong=(CheckBox)findViewById(R.id.checkboxWong);
        btnIrComparar=(Button) findViewById(R.id.btnComparemos);
        logPlaza = (ImageView) findViewById(R.id.logoPlaza);
        valor= getIntent().getStringExtra("arroz");
        //textoPrueba.setText(valor);


        logPlaza.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override

            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    logPlaza.setImageResource(R.drawable.logometro);
                }
                return false;
            }

        });



        btnIrComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(v.getContext(), ComparaActivity.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("arroz",valor);
                inte.putExtras(miBundle);
                if (checkMetro.isChecked()==true & checkPlaza.isChecked()==true & checkTottus.isChecked()==true ){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();
                }else if(checkMetro.isChecked()==true & checkPlaza.isChecked()==true & checkWong.isChecked()==true ) {Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();
                }else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true & checkWong.isChecked()==true){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();}
                else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true & checkWong.isChecked()==true){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();}
                else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true & checkWong.isChecked()==true & checkPlaza.isChecked()==true ){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();}
                else if(checkMetro.isChecked()==true & checkPlaza.isChecked()==true){inte.putExtra("super1","Metro"); inte.putExtra("super2","Plaza"); startActivityForResult(inte,0);}
                else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true){inte.putExtra("super1","Metro"); inte.putExtra("super2","Tottus"); startActivityForResult(inte,0);}
                else if(checkMetro.isChecked()==true & checkWong.isChecked()==true){inte.putExtra("super1","Metro"); inte.putExtra("super2","Wong"); startActivityForResult(inte,0);}
                else if(checkPlaza.isChecked()==true & checkTottus.isChecked()==true){inte.putExtra("super1","Plaza"); inte.putExtra("super2","Tottus"); startActivityForResult(inte,0);}
                else if(checkPlaza.isChecked()==true & checkWong.isChecked()==true){inte.putExtra("super1","Plaza"); inte.putExtra("super2","Wong"); startActivityForResult(inte,0);}
                else if(checkTottus.isChecked()==true & checkWong.isChecked()==true){inte.putExtra("super1","Tottus"); inte.putExtra("super2","Wong"); startActivityForResult(inte,0);}
            }
        });



        bottomNavigationView.setSelectedItemId(R.id.Compara);

        //Realizar el llamado del Item seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Compara:
                        return true;
                    case R.id.Inicio:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.MiPerfil:
                        startActivity(new Intent(getApplicationContext(),MiPerfil2.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}

/*
public class Supermercados extends AppCompatActivity {
    Button btnIrComparar;
    TextView textoPrueba;
    String arroz;
    String valor;
    ImageView logPlaza;
    Integer valid;
    CheckBox checkMetro;
    CheckBox checkPlaza;
    CheckBox checkTottus;
    CheckBox checkWong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruab);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        valid=4;

        checkMetro=(CheckBox) findViewById(R.id.checkboxMetro);
        checkPlaza=(CheckBox)findViewById(R.id.checkboxPlaza);
        checkTottus=(CheckBox)findViewById(R.id.checkboxTottus);
        checkWong=(CheckBox)findViewById(R.id.checkboxWong);
        btnIrComparar=(Button) findViewById(R.id.btnComparemos);
        logPlaza = (ImageView) findViewById(R.id.logoPlaza);
        valor= getIntent().getStringExtra("arroz");
        //textoPrueba.setText(valor);


        logPlaza.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override

            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    logPlaza.setImageResource(R.drawable.logometro);
                }
                return false;
            }

        });



        btnIrComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(v.getContext(), Comparacionproductos.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("arroz",valor);
                inte.putExtras(miBundle);
                if (checkMetro.isChecked()==true & checkPlaza.isChecked()==true & checkTottus.isChecked()==true ){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();
                }else if(checkMetro.isChecked()==true & checkPlaza.isChecked()==true & checkWong.isChecked()==true ) {Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();
                }else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true & checkWong.isChecked()==true){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();}
                else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true & checkWong.isChecked()==true){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();}
                else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true & checkWong.isChecked()==true& checkPlaza.isChecked()==true ){Toast.makeText(Supermercados.this, "Solo puede seleccionar dos Supermercados", Toast.LENGTH_SHORT).show();}
                else if(checkMetro.isChecked()==true & checkPlaza.isChecked()==true){inte.putExtra("super1","Metro"); inte.putExtra("super2","Plaza"); startActivityForResult(inte,0);}
                else if(checkMetro.isChecked()==true & checkTottus.isChecked()==true){inte.putExtra("super1","Metro"); inte.putExtra("super2","Tottus"); startActivityForResult(inte,0);}
                }
        });



        bottomNavigationView.setSelectedItemId(R.id.Compara);

        //Realizar el llamado del Item seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Compara:
                        return true;
                    case R.id.Inicio:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.MiPerfil:
                        startActivity(new Intent(getApplicationContext(),MiPerfil2.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}*/
