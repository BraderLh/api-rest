package com.codigo.apirest.controller;

import com.codigo.apirest.entity.Persona;
import com.codigo.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/guardar")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        return personaService.eliminarPersona(id) ? "Eliminacion exitosa" : "Eliminación fallida";
    }

    @PostMapping("/actualizar")
    public Persona actualizarPersona(@RequestBody Persona persona) {
        return personaService.actualizarPersona(persona);
    }

    @GetMapping("/listar")
    public List<Persona> listarPersona() {
        return personaService.listarPersona();
    }
    //eliminar, listar y actualizar

}
