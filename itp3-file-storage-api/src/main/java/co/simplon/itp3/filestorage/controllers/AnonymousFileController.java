package co.simplon.itp3.filestorage.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;
import co.simplon.itp3.filestorage.dtos.FilesStatDto;
import co.simplon.itp3.filestorage.entities.HttpHeader;
import co.simplon.itp3.filestorage.repositories.HttpHeaderRepository;
import co.simplon.itp3.filestorage.services.AnonymousFileService;

@RestController
@RequestMapping("/anonymous-files")
public class AnonymousFileController {

    private AnonymousFileService service;
    HttpHeader header = new HttpHeader();

    public AnonymousFileController(
	    AnonymousFileService service) {
	this.service = service;
    }

    @Autowired
    private HttpHeaderRepository http_headers;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public FileView upload(
	    @RequestHeader Map<String, String> headers,
	    @ModelAttribute @Valid AnonymousFileData inputs) {

	return service.upload(headers, inputs);
    }

    @GetMapping
    public FilesStatDto filesStat() {
	FilesStatDto stats = service.filesStat();
	return stats;

    }

}
