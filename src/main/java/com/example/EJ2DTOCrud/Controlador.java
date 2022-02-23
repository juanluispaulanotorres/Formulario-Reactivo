package com.example.EJ2DTOCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
        // En caso de error de formato, mostrar el resultado en "String"
        return personaService.listaPersonas();
    }
}
