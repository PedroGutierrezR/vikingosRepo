package com.vikingo.trazap.app.service;

import com.vikingo.trazap.app.service.request.AuthUserRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface AuthService {

	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest);
	
}
