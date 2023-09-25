package co.simplon.itp3.filestorage.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate();
    }

}
