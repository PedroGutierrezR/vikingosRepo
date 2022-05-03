 package com.vikingo.trazap.app.ui.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vikingo.trazap.app.delegate.AuthDelegate;
import com.vikingo.trazap.app.service.request.AuthUserRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;


@RestController
public class AuthController {

	@Autowired
	private AuthDelegate authDelegate;
	
	@PostMapping("/authenticateUser")
	public ResponseEntity<ResponseServiceObject> authenticationUser(@RequestHeader("username") String username, @RequestHeader("password") String pwd){
		ResponseServiceObject responseServiceObject = null;
		AuthUserRequest authUserRequest = new AuthUserRequest();
		authUserRequest.setEmail(username);
		authUserRequest.setPassword(pwd);
		
		responseServiceObject = authDelegate.authenticateUser(authUserRequest);
		return new ResponseEntity<ResponseServiceObject>(responseServiceObject, HttpStatus.OK);
	}
	
}
