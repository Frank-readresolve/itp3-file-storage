package co.simplon.itp3.filestorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAsync
public class Itp3FileStorageApiApplication {

    public static void main(String[] args) {
	SpringApplication.run(Itp3FileStorageApiApplication.class, args);
    }

}
