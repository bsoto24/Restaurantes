package com.codev.restaurantes;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        for (Restaurante r :getData()) {
            mMap.addMarker(new MarkerOptions().position(r.getPosition()).title(r.getNombre()));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-12.0488921,-77.1114906)));
    }


    private ArrayList<Restaurante> getData(){
        ArrayList<Restaurante> data = new ArrayList<>();
        data.add(new Restaurante("Mi Barrunto", "Direccion 1", -12.0676261,-77.0237384));
        data.add(new Restaurante("Rokys", "Direccion 2", -12.048921,-77.1114906));
        data.add(new Restaurante("Pardos", "Direccion 3", -12.0488877,-77.1114907));
        data.add(new Restaurante("La Leña", "Direccion 4", -12.0488944, -77.0852257));
        return data;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent intent = new Intent(MapsActivity.this, RestauranteActivity.class);
        Restaurante res = findRestaurante(marker.getTitle());
        if(res != null){
            Log.e("MAPA", res.toString());
            intent.putExtra("nombre", res.getNombre());
            intent.putExtra("direccion", res.getDireccion());
            startActivity(intent);
        }
        return false;
    }

    private Restaurante findRestaurante(String title) {
        for (Restaurante r : getData()) {
            if(r.getNombre().equals(title)){
                return r;
            }
        }
        return null;
    }
}
