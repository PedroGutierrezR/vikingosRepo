package com.vikingo.trazap.app.delegate;

import com.vikingo.trazap.app.service.request.AuthUserRequest;
import com.vikingo.trazap.app.service.response.ResponseServiceObject;

public interface AuthDelegate {
	public ResponseServiceObject authenticateUser(AuthUserRequest authUserRequest);
}
