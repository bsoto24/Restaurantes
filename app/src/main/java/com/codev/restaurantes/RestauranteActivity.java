package com.codev.restaurantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestauranteActivity extends AppCompatActivity {

    private TextView tvRestaurante, tvDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        tvRestaurante = (TextView) findViewById(R.id.tv_restaurante);
        tvDireccion = (TextView) findViewById(R.id.tv_direccion);

        tvRestaurante.setText(getIntent().getStringExtra("nombre"));
        tvDireccion.setText(getIntent().getStringExtra("direccion"));
    }
}
