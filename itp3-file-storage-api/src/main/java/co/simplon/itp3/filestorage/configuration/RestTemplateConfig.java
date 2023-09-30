package co.simplon.itp3.filestorage.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${send-mail-api.root}")
    private String mailRootUri;

    @Value("${send-mail-api.customer-number.header.value}")
    private String clientNumber;

    @Value("${send-mail-api.credentials.header.value}")
    private String credentials;

    public RestTemplateConfig() {

    }

    @Bean
    public RestTemplate mailRestTemplate(
	    RestTemplateBuilder builder) {
	RestTemplate template = builder.rootUri(mailRootUri)
		.defaultHeader("API-Customer-Number",
			clientNumber)
		.defaultHeader("API-Key", credentials)
		.build();
	return template;
    }

}
