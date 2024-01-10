package com.ecomerce.fis.controllers;
import com.ecomerce.fis.repository.Repository;
import com.ecomerce.fis.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPersona {

    @Autowired
    private Repository repo;

    @GetMapping
    public String index() {
        return "CONECTADO";
    }

    @GetMapping("personas")
    public List<Persona> getPersonas() {
        return repo.findAll();
    }

    @PostMapping("personas")
    public String post(@RequestBody Persona persona) {
        repo.save(persona);
        return "Grabado";

    }

    @PutMapping("personas/{id}")
    public String updatePerson(@PathVariable Long id, @RequestBody Persona persona) {

    Persona updatePersona = repo.findById(id).get();
    updatePersona.setNombre(persona.getNombre());
    updatePersona.setTelefono(persona.getTelefono());
    updatePersona.setRol(persona.getRol());
    updatePersona.setUsername(persona.getUsername());
    updatePersona.setPassword(persona.getPassword());


    repo.save(updatePersona);
    return "Editado Correctamente";
}
@DeleteMapping("personas/{id}")
    public String delete(@PathVariable Long id){
        Persona deletePersona =repo.findById(id).get();
        repo.delete(deletePersona);
    return "Eliminado";
    }


}
