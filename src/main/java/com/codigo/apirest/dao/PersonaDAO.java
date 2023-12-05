package com.codigo.apirest.dao;

import com.codigo.apirest.entity.Persona;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDAO  extends JpaRepository<Persona, Long> {

}
