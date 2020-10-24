package com.bruster.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruster.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {
	
}
