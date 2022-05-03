package com.vikingo.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikingo.trazap.app.delegate.AuthDelegate;
import com.vikingo.trazap.app.service.AuthService;
import com.vikingo.trazap.app.service.request.AuthUserRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

@Component("authDelegate")
public class AuthDelegateImpl implements AuthDelegate {

	@Autowired
	private AuthService authService;
	
	@Override
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest) {
		return authService.authenticateUser(authUserRequest);
	}

}
