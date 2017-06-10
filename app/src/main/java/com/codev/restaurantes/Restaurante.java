package com.codev.restaurantes;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Bryam Soto on 10/06/2017.
 */

public class Restaurante implements Serializable{

    private String nombre;
    private String direccion;
    private LatLng position;

    public Restaurante(String nombre, String direccion, double latitude, double longitude) {
        this.nombre = nombre;
        this.direccion = direccion;
        position = new LatLng(latitude, longitude);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", position=" + position +
                '}';
    }
}
