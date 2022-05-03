package com.vikingo.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vikingo.trazap.app.repository.UsuarioRepository;
import com.vikingo.trazap.app.repository.model.Usuario;
import com.vikingo.trazap.app.service.AuthService;
import com.vikingo.trazap.app.service.request.AuthUserRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceMessage;
import com.vikingo.trazap.app.service.response.ResponseServiceMessageType;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service("authService")
public class AuthServiceImpl implements UserDetailsService, AuthService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Usuario> listaUsuarios = usuarioRepository.findByEmail(username);
		Usuario usuario = null;
		UserBuilder builder = null;
		
		if(listaUsuarios == null || listaUsuarios.size() != 1) {
			throw new UsernameNotFoundException(username);
		}else {
			usuario = listaUsuarios.get(0);
			builder = User.withUsername(username);
			//builder.password(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			builder.password(usuario.getPassword());
			String[] roles = {usuario.getRol().getDescripcion()};
			builder.roles(roles);
		}
		
		return builder.build();
	}

	
	@Override
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest) {
		ResponseServiceObject responseServiceObject = null;
		ResponseServiceMessage responseServiceMessage = null;
		List<ResponseServiceMessage> messageList = null;
		List<Usuario> listaUsuarios = null;
		
		try {
			responseServiceObject = new ResponseServiceObject();
			responseServiceMessage = new ResponseServiceMessage();
			messageList = new ArrayList<ResponseServiceMessage>();
			listaUsuarios = usuarioRepository.findByEmail(authUserRequest.getEmail());
			if(listaUsuarios != null && listaUsuarios.size() == 1) {
				if(encoder.matches(authUserRequest.getPassword(), listaUsuarios.get(0).getPassword())) {
					String token = getJWTToken(listaUsuarios.get(0));
					responseServiceMessage.setCode(String.valueOf( HttpStatus.OK.value()));
					responseServiceMessage.setTimestamp(new Date());
					responseServiceMessage.setType(ResponseServiceMessageType.OK);
					responseServiceMessage.setMessage("Usuario autenticado");
					messageList.add(responseServiceMessage);
					responseServiceObject.setMessageList(messageList);
					responseServiceObject.setBody(token);
				} else {
					//Respuesta nula con mensaje
					responseServiceMessage.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
					responseServiceMessage.setTimestamp(new Date());
					responseServiceMessage.setType(ResponseServiceMessageType.OK);
					responseServiceMessage.setMessage("Usuario NO autenticado: Password incorrecta");
					messageList.add(responseServiceMessage);
					responseServiceObject.setMessageList(messageList);
					responseServiceObject.setBody(null);
				}
			} else {
				//Respuesta nula con mensaje
				responseServiceMessage.setCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
				responseServiceMessage.setTimestamp(new Date());
				responseServiceMessage.setType(ResponseServiceMessageType.OK);
				responseServiceMessage.setMessage("Usuario NO autenticado: Usuario no existe o está duplicado");
				messageList.add(responseServiceMessage);
				responseServiceObject.setMessageList(messageList);
				responseServiceObject.setBody(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseServiceObject;
	}
	
	private String getJWTToken(Usuario usuario) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + usuario.getRol().getDescripcion());
		String token = Jwts
						.builder()
						.setId("vikingosJWT")
						.setSubject(usuario.getEmail())
						.claim("authorities",
								grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
									.setIssuedAt(new Date(System.currentTimeMillis()))
									.setExpiration(new Date(System.currentTimeMillis() + 60000))
									.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		return "Vikingo " + token;
	}
	
}
