package com.bootcamp.deportistas.appdeportistas.entity.deporte;

import com.bootcamp.deportistas.appdeportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.appdeportistas.models.Deporte;
import com.bootcamp.deportistas.appdeportistas.models.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteHandler implements IDeporte<Deporte> {

    private final List<Deporte> deportes = new ArrayList<>(
            List.of(new Deporte("Futbol","profesional")
                    ,new Deporte("Basketball","Aficionado")
                    ,new Deporte("Golf","Profesional")
                    ,new Deporte("Baseball","Aficionado")
            )

    );
    @Override
    public String findAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deportes=").append("\n");
        this.deportes.forEach(deporte -> {
            DeporteDTO deporteDTO = new DeporteDTO();
            deporteDTO.setNombre(deporte.getNombre());
            deporteDTO.setNivel(deporte.getNivel());
            sb.append("{ Nombre = ").append(deporteDTO.getNombre()).append("\n")
                    .append("Nivel= ").append(deporteDTO.getNivel()).append(" }");
        });
        return sb.toString();
    }

    @Override
    public String findOne(String nombreABuscar) {

        if(this.deportes.stream().anyMatch(deporte -> deporte.getNombre().equals(nombreABuscar))){
            Deporte deporteEncontrado = this.deportes.stream().filter(deporte -> deporte.getNombre().equals(nombreABuscar)).findFirst().get();
            DeporteDTO deporteDTO = new DeporteDTO();
            deporteDTO.setNombre(deporteEncontrado.getNombre());
            deporteDTO.setNivel(deporteEncontrado.getNivel());
            return "Deporte encontrado{"+"\n"+"\t Nombre= "+ deporteDTO.getNombre()+", \n"
                                +"\t Nivel"+deporteDTO.getNivel()+"\n }";
        }


        return "Deporte no encontrado";
    }

    @Override
    public boolean addOne(Deporte nuevoElemento) {

        if(this.deportes.stream().noneMatch(d -> d.getId() == nuevoElemento.getId()) &&
                this.deportes.stream().noneMatch(d -> d.getNombre().equals(nuevoElemento.getNombre()))){
            this.deportes.add(nuevoElemento);
            return true;
        }
        return false;
    }
}
