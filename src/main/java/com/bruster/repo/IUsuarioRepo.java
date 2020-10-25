package com.bruster.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruster.model.Persona;
import com.bruster.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	Usuario findByNombre(String nombre);
}
