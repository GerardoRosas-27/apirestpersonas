package com.bruster.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruster.PersonaapirestApplication;
import com.bruster.model.Persona;
import com.bruster.repo.IPersonaRepo;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private static Logger LOG = LoggerFactory.getLogger(PersonaapirestApplication.class); 
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping()
	public List<Persona> listarPersonas() {
		return repo.findAll();
	}
    @GetMapping(value = "/{id}")
    public Optional<Persona> buscarPersona(@PathVariable("id") Integer id) {
    	LOG.info("id mandado: " + id);
		return repo.findById(id);
	}
	@PostMapping()
	public void insertar(@RequestBody Persona persona) {
		repo.save(persona);
	}
	
	@PutMapping
	public void actualizar(@RequestBody Persona persona) {
		repo.save(persona);
	}
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
