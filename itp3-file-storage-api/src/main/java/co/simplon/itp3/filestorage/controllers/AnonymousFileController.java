package co.simplon.itp3.filestorage.controllers;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;
import co.simplon.itp3.filestorage.services.AnonymousFileService;

@RestController
@RequestMapping("/anonymous-files")
public class AnonymousFileController {

    private AnonymousFileService service;

    public AnonymousFileController(
	    AnonymousFileService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<FileView> upload(
	    @ModelAttribute @Valid AnonymousFileData inputs) {
	return service.upload(inputs);
    }
}
