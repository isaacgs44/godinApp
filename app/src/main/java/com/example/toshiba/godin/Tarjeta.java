package com.example.toshiba.godin;

/**
 * Created by toshiba on 19/09/16.
 */
public class Tarjeta {
    private String nombre;
    private Double saldo;

    public Tarjeta(String nombre, Double saldo){
        this.nombre=nombre;
        this.saldo=saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
