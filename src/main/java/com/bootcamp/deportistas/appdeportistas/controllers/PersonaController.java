package com.bootcamp.deportistas.appdeportistas.controllers;

import com.bootcamp.deportistas.appdeportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.appdeportistas.entity.persona.IPersona;
import com.bootcamp.deportistas.appdeportistas.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersona<Persona> personaHandler;

    @GetMapping("/mostrartodo")
    public List<PersonaDTO> personaEndPoint(){
        return personaHandler.findAll();
    }

}
