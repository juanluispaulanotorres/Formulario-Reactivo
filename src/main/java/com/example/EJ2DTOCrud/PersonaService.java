package com.example.EJ2DTOCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements iPersona{

    @Autowired
    PersonaRepositorio personaRepositorio;

    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if (personaInputDTO.getUsuario() == null) {
            throw new Exception("Usuario no puede ser nulo");

        } else if (personaInputDTO.getUsuario().length() > 10) {
            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");

        } else {
            Persona persona = new Persona(personaInputDTO);
            personaRepositorio.save(persona);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);

            return personaOutputDTO;
        }
    }

    @Override
    public List<PersonaOutputDTO> listaPersonas() {
        List<PersonaOutputDTO> lista;
        lista = personaRepositorio.findAll().stream().map(persona -> new PersonaOutputDTO(persona)).collect(Collectors.toList());
        return lista;
    }

    @Override
    public PersonaOutputDTO idPersona(int id) throws Exception {
        Persona persona = personaRepositorio.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado a la persona solicitada"));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;
    }

    @Override
    public PersonaOutputDTO usuarioPersona(String usuario) {
        List<PersonaOutputDTO> lista = this.listaPersonas();

        for (int i = 0; i < lista.size(); i++) {
            PersonaOutputDTO personaOutputDTO;
            personaOutputDTO = lista.get(i);

            if (personaOutputDTO.getUsuario().equalsIgnoreCase(usuario)) {
                return personaOutputDTO;
            }
        }
        return null;
    }

    @Override
    public void modificaPersona(int id, PersonaInputDTO personaInputDTO) {
        // Recuperar la lista de las personas y recorrerla con un bucle para encontrar la solicitada y modificarla
        List<PersonaOutputDTO> lista = this.listaPersonas();

        for (int i = 0; i < lista.size(); i++) {
            PersonaOutputDTO p;
            p = lista.get(i);
            if (p.getId_persona() == id) {
                Persona persona = new Persona(personaInputDTO);
                // IMPORTANTE: Hay que establecer el nuevo "id" de la persona usando el que pasamos como parámetro
                persona.setId_persona(id);

                personaRepositorio.save(persona);
            }
        }
    }

    @Override
    public void eliminaPersona(int id) throws Exception {
        try {
            personaRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new Exception("La persona que busca no se encuentra en la base de datos");
        }
    }
}
