package com.codigo.apirest.service.impl;

import com.codigo.apirest.dao.PersonaDAO;
import com.codigo.apirest.entity.Persona;
import com.codigo.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaDAO personaDAO;

    public Persona guardarPersona(Persona persona) {
        return personaDAO.save(persona);
    }
    public boolean eliminarPersona(Long id) {
        boolean isSuccess = false;
        if (id!=null && personaDAO.existsById(id)) {
            personaDAO.deleteById(id);
            isSuccess = true;
        } else {
            System.out.println("Id no valido");
        }
        return isSuccess;
    }

    public Persona actualizarPersona(Persona persona) {
        Persona personaActualizar = personaDAO.getReferenceById(persona.getId());
            if (personaDAO.existsById(personaActualizar.getId())) {
                personaActualizar.setNombre(persona.getNombre().isEmpty() ? personaActualizar.getNombre() : persona.getNombre());
                personaActualizar.setApellidos(persona.getApellidos().isEmpty() ? personaActualizar.getApellidos() : persona.getApellidos());
                personaActualizar.setEmail(persona.getEmail().isEmpty() ? personaActualizar.getEmail() : persona.getEmail());
                personaActualizar.setTelefono(persona.getTelefono().isEmpty() ? personaActualizar.getTelefono() : persona.getTelefono());
                personaActualizar.setEdad(persona.getEdad() == 0 ? personaActualizar.getEdad() : persona.getEdad());
                personaActualizar.setEstado(persona.getEstado() == 0 ? personaActualizar.getEstado() : persona.getEstado());
                personaActualizar = personaDAO.save(personaActualizar);
            } else {
                System.out.println("ID no válido");
                return null;
            }
        return personaActualizar;
    }
    public List<Persona> listarPersona() { return personaDAO.findAll();};
}
