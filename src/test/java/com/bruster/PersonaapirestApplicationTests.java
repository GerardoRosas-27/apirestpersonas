package com.bruster;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.bruster.model.Usuario;
import com.bruster.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonaapirestApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setNombre("gerardo rosas");
		usuario.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(usuario);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(usuario.getClave()));
	}

}
