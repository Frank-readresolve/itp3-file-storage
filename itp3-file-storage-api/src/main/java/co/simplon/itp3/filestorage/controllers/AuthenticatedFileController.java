package co.simplon.itp3.filestorage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticated-files")
public class AuthenticatedFileController {

    public AuthenticatedFileController() {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String storeAuthenticatedFile() {
	return "You have stored an authenticated file.";
    }

}
