package com.example.comparaapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final int REQUEST_ACCESS_FINE = 0;
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    //private FusedLocationProviderCLient mFusedLocationProviderCLient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mMapFragment != null;
        mMapFragment.getMapAsync(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest
                .permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest
                    .permission.ACCESS_FINE_LOCATION}, REQUEST_ACCESS_FINE);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_ACCESS_FINE){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permiso Brindado, ¡gracias!",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Permiso Denegado!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        // --------------------------------------------------------

        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng casa = new LatLng(-12.006264, -77.003925);
        LatLng metroAgustino = new LatLng(-12.039450, -77.002902);

        /*LatLng marcador1 = new LatLng(-12.039450, -77.002902);
        mMap.addMarker(new MarkerOptions()
                .position(marcador1)
                .title("Metro Agustino Plaza")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.market)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marcador1));
        LatLng marcador2 = new LatLng(-12.01704,-76.9953073);
        mMap.addMarker(new MarkerOptions()
                .position(marcador2)
                .title("PlazaVea Hiper Zárate")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.market)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marcador2));*/


        mMap.addMarker(new MarkerOptions().position(metroAgustino).title("Metro"));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                new CameraPosition.Builder()
                        .target(new LatLng(-12.039450, -77.002902))
                        .zoom(17f)
                        .build()
        ));

        // Centrar Marcadores
        /*LatLngBounds.Builder constructor = new LatLngBounds.Builder();

        constructor.include(marcador1);
        constructor.include(marcador2);

        LatLngBounds limites = constructor.build();

        int ancho = getResources().getDisplayMetrics().widthPixels;
        int alto = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (alto * 0.25); // 25% de espacio (padding) superior e inferior

        CameraUpdate centrarmarcadores = CameraUpdateFactory.newLatLngBounds(limites, ancho, alto, padding);

        mMap.animateCamera(centrarmarcadores);
*/
    }


    /*public void Antutu(GoogleMap googleMap){
        mMap = googleMap;
        final LatLng punto1 = new LatLng(-12.039450, -77.002902);

        mMap.addMarker(new MarkerOptions().position(punto1).title("Metro Agustino"));
    }*/


}