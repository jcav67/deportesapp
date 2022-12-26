package com.bootcamp.deportistas.appdeportistas.entity.persona;

import com.bootcamp.deportistas.appdeportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.appdeportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.appdeportistas.entity.deporte.DeporteHandler;
import com.bootcamp.deportistas.appdeportistas.models.Deporte;
import com.bootcamp.deportistas.appdeportistas.models.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaImplement implements IPersona<Persona> {

        private final List<Persona> personas = new ArrayList<>(
                List.of(new Persona("Camilo", "Arango", "12312", 28, 2)
                        , new Persona("Andres", "Guzman", "33333", 48,3)
                        , new Persona("Luis", "Restrepo", "31233", 18,1)
                )
        );

        @Override
        public List<PersonaDTO> findAll() {
                List<PersonaDTO> personasDTOList = new ArrayList<>();
                PersonaDTO personaDto = new PersonaDTO();
                for (Persona persona: personas) {
                        personaDto = findOne(persona.getNombre());
                        personasDTOList.add(personaDto);
                }
                //this.personas.forEach(persona -> sb.append(persona.toString()).append("\n"));
                return personasDTOList;

        }

        public PersonaDTO findOne(String nombreABuscar) {
                DeporteHandler deporteHandler = new DeporteHandler();
                PersonaDTO personaDTO = new PersonaDTO();
                if (personas.stream().anyMatch(persona1 -> persona1.getNombre().equals(nombreABuscar))) {
                        for (Persona persona: personas) {
                                if(persona.getNombre().equals(nombreABuscar)){
                                        Deporte deporte = deporteHandler.findOneById(persona.getDeporteId());
                                        DeporteDTO deporteDTO = new DeporteDTO();
                                        deporteDTO.setNombre(deporte.getNombre());
                                        deporteDTO.setNivel(deporte.getNivel());
                                        personaDTO.setDeporte(deporteDTO);
                                        personaDTO.setNombre(persona.getNombre());
                                        personaDTO.setApellido(persona.getApellido());
                                        break;
                                }
                        }
                        return personaDTO;
                        //return personas.stream().filter(persona1 -> persona1.getNombre().equals(nombreABuscar)).findFirst().get();
                } else {
                        return null;

                }

        }

        @Override
        public boolean addOne(Persona nuevoElemento) {
                if (personas.stream().anyMatch(persona1 -> persona1.getId() != nuevoElemento.getId())) {
                        personas.add(nuevoElemento);
                        return true;
                }
                return false;
        }
}