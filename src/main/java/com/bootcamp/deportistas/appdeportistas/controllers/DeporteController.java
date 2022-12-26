package com.bootcamp.deportistas.appdeportistas.controllers;

import com.bootcamp.deportistas.appdeportistas.entity.deporte.IDeporte;
import com.bootcamp.deportistas.appdeportistas.models.Deporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private IDeporte<Deporte> deporteHandler;

    @GetMapping("/mostrartodo")
    public String mostrarTodos(){
        return deporteHandler.findAll();
    }

    @GetMapping("/mostrardeporte/{deporte}")
    public String mostrarUno(@PathVariable String deporte){
        return deporteHandler.findOne(deporte);
    }

    @PostMapping("/nuevodeporte/")
    public String guardarRegistro(@RequestBody Deporte newDeporte){
        if(deporteHandler.addOne(newDeporte)){
            return "Registro guardado con éxito";
        }
        return "Error al ingresar nuevo deporte";
    }
}
