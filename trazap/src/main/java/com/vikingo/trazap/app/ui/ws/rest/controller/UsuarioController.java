package com.vikingo.trazap.app.ui.ws.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikingo.trazap.app.repository.model.Rol;
import com.vikingo.trazap.app.repository.model.Usuario;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@RestController
@RequestMapping("/ws/usuarios")
public class UsuarioController {
	
	@GetMapping
	public ResponseEntity<ResponseServiceObject> getUsuarios(){
		
		Usuario usuarioAdmin = new Usuario();
		Rol rol = new Rol();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		rol.setDescripcion("ADMIN");
		
		usuarioAdmin.setNombre("Pedro Gutierrez");
		usuarioAdmin.setEmail("pedro@gmail.com");
		usuarioAdmin.setPassword("1234");
		usuarioAdmin.setRol(rol);
		listaUsuario.add(usuarioAdmin);
		ResponseServiceObject response = new ResponseServiceObject();
		response.setBody(listaUsuario);
		return new ResponseEntity<ResponseServiceObject>(response, HttpStatus.OK);
	}
}
