package com.bootcamp.deportistas.appdeportistas.entity.deporte;

import com.bootcamp.deportistas.appdeportistas.models.Persona;

public interface IDeporte<T> {

    public String findAll();

    public String findOne(String nombreABuscar);

    public boolean addOne(T nuevoElemento);
}
