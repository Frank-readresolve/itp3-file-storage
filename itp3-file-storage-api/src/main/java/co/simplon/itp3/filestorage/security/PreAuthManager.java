package co.simplon.itp3.filestorage.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import co.simplon.itp3.filestorage.services.AuthService;

@Component
public class PreAuthManager
	implements AuthenticationManager {

    private final AuthService service;

    public PreAuthManager(AuthService service) {
	this.service = service;
    }

    @Override
    public Authentication authenticate(
	    Authentication authentication)
	    throws AuthenticationException {
	String principal = (String) authentication
		.getPrincipal();
	String credentials = (String) authentication
		.getCredentials();
	service.authenticate(principal, credentials);
	authentication.setAuthenticated(true);
	return authentication;
    }

}
