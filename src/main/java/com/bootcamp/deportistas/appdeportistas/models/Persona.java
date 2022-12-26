package com.bootcamp.deportistas.appdeportistas.models;

import java.io.Serializable;

public class Persona implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String celular;
    private int edad;
    private int deporteId;

    private static int idActual = 0;

    public Persona() {

    }

    public Persona(String nombre, String apellido, String celular, int edad, int deporteId) {
        this.id = ++idActual;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.edad = edad;
        this.deporteId = deporteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public int getDeporteId() {
        return deporteId;
    }

    public void setDeporteId(int deporteId) {
        this.deporteId = deporteId;
    }
}
