package com.example.android.computadores;

/**
 * Created by Android on 28/05/2018.
 */

public class Computador {

    private int foto;
    private String Tipo;
    private String Marca;
    private String Color;
    private String Soperativo;
    private int Ram;

    public Computador(int foto, String tipo, String marca, String color, String soperativo, int ram) {
        this.foto = foto;
        Tipo = tipo;
        Marca = marca;
        Color = color;
        Soperativo = soperativo;
        Ram = ram;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getSoperativo() {
        return Soperativo;
    }

    public void setSoperativo(String soperativo) {
        Soperativo = soperativo;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }
}
