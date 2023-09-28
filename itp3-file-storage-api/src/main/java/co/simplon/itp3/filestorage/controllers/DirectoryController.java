package co.simplon.itp3.filestorage.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.DirectoryData;
import co.simplon.itp3.filestorage.dtos.DirectoryView;
import co.simplon.itp3.filestorage.services.DirectoryService;

@RestController
@RequestMapping("/directory")
public class DirectoryController {

    private DirectoryService service;

    public DirectoryController(DirectoryService service) {
	this.service = service;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DirectoryView createDirectory(@Valid @RequestBody DirectoryData inputs) {
	return service.createDirectory(inputs);
    }
}