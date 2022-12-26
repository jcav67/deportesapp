package com.bootcamp.deportistas.appdeportistas.models;

public class Deporte {

    private int id;
    private String nombre;
    private String nivel;

    private static int idActual = 0;

    public Deporte(){

    }

    public Deporte( String nombre, String nivel) {
        this.id = ++idActual;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }
}
