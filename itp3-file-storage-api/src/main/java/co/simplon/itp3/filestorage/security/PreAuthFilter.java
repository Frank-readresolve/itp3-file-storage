package co.simplon.itp3.filestorage.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class PreAuthFilter
	extends AbstractPreAuthenticatedProcessingFilter {

    private final String clientNumberHeader;

    private final String credentialsHeader;

    public PreAuthFilter(String clientNameHeader,
	    String credentialsHeader) {
	this.clientNumberHeader = clientNameHeader;
	this.credentialsHeader = credentialsHeader;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(
	    HttpServletRequest request) {
	return headerValue(request, clientNumberHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(
	    HttpServletRequest request) {
	return headerValue(request, credentialsHeader);
    }

    private static String headerValue(
	    HttpServletRequest request, String headerName) {
	String value = request.getHeader(headerName);
	return value == null ? "" : value;
    }
}
