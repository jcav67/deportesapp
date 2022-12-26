package com.bootcamp.deportistas.appdeportistas.entity.persona;

import com.bootcamp.deportistas.appdeportistas.dto.PersonaDTO;

import java.util.List;

public interface IPersona<T> {

    public List<PersonaDTO> findAll();

    public PersonaDTO findOne(String nombreABuscar);

    public boolean addOne(T nuevoElemento);
}

