package com.bootcamp.deportistas.appdeportistas.entity.persona;

import com.bootcamp.deportistas.appdeportistas.models.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaImplement implements IPersona<Persona> {

        private final List<Persona> personas = new ArrayList<>(
                List.of(new Persona("Camilo", "Arango", "12312", 28)
                        , new Persona("Andres", "Guzman", "33333", 48)
                        , new Persona("Luis", "Restrepo", "31233", 18)
                )
        );

        @Override
        public String findAll() {
                StringBuilder sb = new StringBuilder();
                this.personas.forEach(persona -> sb.append(persona.toString()).append("\n"));
                return sb.toString();
        }

        public Persona findOne(String nombreABuscar) {
                if (personas.stream().anyMatch(persona1 -> persona1.getNombre().equals(nombreABuscar))) {
                        return personas.stream().filter(persona1 -> persona1.getNombre().equals(nombreABuscar)).findFirst().get();
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