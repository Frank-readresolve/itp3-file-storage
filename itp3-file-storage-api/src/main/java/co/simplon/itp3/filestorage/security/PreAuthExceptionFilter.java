package co.simplon.itp3.filestorage.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;

public class PreAuthExceptionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req,
	    ServletResponse res, FilterChain chain)
	    throws IOException, ServletException {
	try {
	    chain.doFilter(req, res);
	} catch (BadCredentialsException ex) {
	    HttpServletResponse response = (HttpServletResponse) res;
	    response.setStatus(
		    HttpStatus.UNAUTHORIZED.value());
	}
    }
}
