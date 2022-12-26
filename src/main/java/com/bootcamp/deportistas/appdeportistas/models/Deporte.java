package com.bootcamp.deportistas.appdeportistas.models;

public class Deporte {

    private int id;
    private String nombre;
    private String nivel;

    public Deporte(){

    }

    public Deporte(int id, String nombre, String nivel) {
        this.id = id;
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
