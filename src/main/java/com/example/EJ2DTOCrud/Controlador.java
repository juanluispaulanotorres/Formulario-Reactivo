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
        return "Persona creada correctamente \n" + personaService.addPersona(persona);
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
    @GetMapping("/personaUsuario/{usuario}")
    public PersonaOutputDTO usuarioPersona(@PathVariable String usuario) {
        return personaService.usuarioPersona(usuario);
    }

    // Modificar usuario
   /* @GetMapping("/modificar/{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody PersonaInputDTO persona) {
        personaService.modificaPersona(id, persona);
    }*/

    @GetMapping("/eliminar/{id}")
    public String eliminaPersona(@PathVariable int id) throws Exception {
        personaService.eliminaPersona(id);
        return "Persona eliminada de la base de datos";
    }
}
