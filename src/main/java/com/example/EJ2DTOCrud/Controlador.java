package com.example.EJ2DTOCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {

    @Autowired
    PersonaService personaService;

    @PostMapping("/addPersona")
    public String addPersona(@RequestBody PersonaInputDTO persona) throws Exception {
        personaService.addPersona(persona);
        return "Persona creada correctamente";
    }

    @GetMapping("/listadoPersonas")
    public List<PersonaOutputDTO> listaPersonas() {
        return personaService.listaPersonas();
    }

    // Mostrar persona por "id"
    @GetMapping("/persona/{id}")
    public PersonaOutputDTO idPersona(@PathVariable int id) throws Exception{
        return personaService.idPersona(id);
    }

    // Mostrar persona por "usuario"
    /*@GetMapping("/persona/{usuario}")
    public List<PersonaOutputDTO> usuarioPersona(@PathVariable String usuario) {
        return personaService.usuarioPersona(usuario);
    }*/

    // Modificar usuario
    /*@GetMapping("/modificar/{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody Persona persona) {
        personaService.modificaPersona(id, persona);
    }*/
}
