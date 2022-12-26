package com.bootcamp.deportistas.appdeportistas.entity.persona;

import com.bootcamp.deportistas.appdeportistas.models.Persona;

import java.util.List;

public interface IPersona<T> {

    public String findAll();

    public Persona findOne(String nombreABuscar);

    public boolean addOne(T nuevoElemento);
}

