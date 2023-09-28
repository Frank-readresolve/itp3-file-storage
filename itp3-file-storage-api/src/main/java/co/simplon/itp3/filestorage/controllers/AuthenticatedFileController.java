package co.simplon.itp3.filestorage.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.AuthenticatedFileData;
import co.simplon.itp3.filestorage.dtos.FileView;
import co.simplon.itp3.filestorage.services.AuthenticatedFileService;

@RestController
@RequestMapping("/authenticated")
public class AuthenticatedFileController {

    private final AuthenticatedFileService service;

    public AuthenticatedFileController(
	    AuthenticatedFileService service) {
	this.service = service;
    }

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<FileView> upload(
	    AuthenticatedFileData inputs) {
	return service.upload(inputs);
    }

}
