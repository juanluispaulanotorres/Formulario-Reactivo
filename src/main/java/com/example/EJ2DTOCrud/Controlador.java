package com.example.EJ2DTOCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controlador {
    @GetMapping
    public String getHola() {
        return "Hola";
    }

    @Autowired
    PersonaService personaService;

    @PostMapping("/addPersona")
    public String addPersona(@RequestBody PersonaInputDTO persona) throws Exception {
        personaService.addPersona(persona);
        return "Persona creada correctamente";
    }

    @GetMapping("/listadoPersonas")
    public List<Persona> listaPersonas() {
        return personaService.listaPersonas();
    }

    // Mostrar persona por id
    @GetMapping("/persona/{id}")
    public Optional<Persona> idPersona(@PathVariable int id) {
        return personaService.idPersona(id);
    }
}
