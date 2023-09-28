package co.simplon.itp3.filestorage.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ApiSecurityConfig {

    @Value("${itp3-file-storage-api.customer-number.header}")
    private String clientNumberHeader;

    @Value("${itp3-file-storage-api.credentials.header}")
    private String credentialsHeader;

    private final AuthenticationManager manager;

    public ApiSecurityConfig(
	    AuthenticationManager manager) {
	this.manager = manager;
    }

    @Bean
    protected SecurityFilterChain filterChain(
	    HttpSecurity http) throws Exception {
	http.csrf().disable().sessionManagement()
		.sessionCreationPolicy(
			SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(preAuthExceptionFilter(),
			SecurityContextHolderFilter.class)
		.addFilterAfter(preAuthFilter(),
			PreAuthFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,
			"/authenticated/upload")
		.fullyAuthenticated()
		.antMatchers(HttpMethod.POST,
			"/anonymous-files")
		.anonymous(); // Fully protected endpoint without anonymous included
	return http.build();
    }

    @Bean
    protected Filter preAuthFilter() {
	PreAuthFilter filter = new PreAuthFilter(
		clientNumberHeader, credentialsHeader);
	filter.setAuthenticationManager(manager);
	filter.setContinueFilterChainOnUnsuccessfulAuthentication(
		false);
	filter.setRequiresAuthenticationRequestMatcher(
		new AntPathRequestMatcher(
			"/authenticated/upload", "POST"));
	return filter;
    }

    @Bean
    protected Filter preAuthExceptionFilter() {
	return new PreAuthExceptionFilter();
    }

}
