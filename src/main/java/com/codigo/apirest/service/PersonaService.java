package com.codigo.apirest.service;

import com.codigo.apirest.entity.Persona;

import java.util.List;

public interface PersonaService {
    Persona guardarPersona(Persona persona);
    public boolean eliminarPersona(Long id);
    public Persona actualizarPersona(Persona persona);
    public List<Persona> listarPersona();
}
