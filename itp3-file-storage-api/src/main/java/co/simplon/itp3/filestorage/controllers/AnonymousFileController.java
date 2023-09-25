package co.simplon.itp3.filestorage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.services.AnonymousFileService;

@RestController
@RequestMapping("/anonymous-files")
public class AnonymousFileController {

    private AnonymousFileService service;

    public AnonymousFileController(
	    AnonymousFileService service) {
	this.service = service;
    }
}
