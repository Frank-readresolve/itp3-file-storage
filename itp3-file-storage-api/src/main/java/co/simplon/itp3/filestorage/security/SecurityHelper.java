package co.simplon.itp3.filestorage.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * A helper class to deal with the security context.
 */
public final class SecurityHelper {

    private SecurityHelper() {
	// Ensures non-instantiability
    }

    /**
     * Returns the name of the authenticated client.
     *
     * @return the name of the authenticated client
     */
//    public static String authenticatedCustomer() {
//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	String numberCustomer = auth.getName();
//	return numberCustomer;
//    }
    public static String authenticatedCustomer() {
	Authentication auth = SecurityContextHolder
		.getContext().getAuthentication();
	String customerNumber = auth.getName();
	return customerNumber;
    }

}
