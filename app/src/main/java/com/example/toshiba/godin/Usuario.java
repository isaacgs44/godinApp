package com.example.toshiba.godin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by toshiba on 19/09/16.
 */
public class Usuario implements Serializable{
    public static String nombre;
    protected static List<Tarjeta> tarjetas;

    public Usuario(String nombre){
        this.nombre=nombre;
        tarjetas = new ArrayList<>();
        llenaTarjetas();
    }

    private void llenaTarjetas() {
        tarjetas.add(new Tarjeta("banamex",100.00));
        tarjetas.add(new Tarjeta("banorte",2500.50));
    }

    static List<Tarjeta> getTarjetas(){
        return tarjetas;

    }

    static void addTarjeta(String nombre, Double saldo){
        Tarjeta t =  new Tarjeta(nombre, saldo);
            tarjetas.add(t);
        }

    static String getNombre() {
        return nombre;
    }
}


