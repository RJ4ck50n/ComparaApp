package com.example.comparaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Comparacionproductos extends AppCompatActivity {
    TextView primerproducto;
    TextView txtSup1;
    TextView txtSup2;
    String super1;
    String super2;
    String arroz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacionproductos);

        primerproducto=(TextView) findViewById(R.id.productoArroz);
        txtSup1=(TextView) findViewById(R.id.txtSuper1);
        txtSup2=(TextView) findViewById(R.id.txtSuper2);
        Bundle miBundle=this.getIntent().getExtras();

        if(miBundle!=null){
            arroz=miBundle.getString("arroz");
            primerproducto.setText(arroz);
            super1=miBundle.getString("super1");
            super2= miBundle.getString("super2");
            txtSup1.setText(super1);
            txtSup2.setText(super2);

        }
    }
}