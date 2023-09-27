package co.simplon.itp3.filestorage.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.AnonymousFileData;
import co.simplon.itp3.filestorage.dtos.FileView;
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
	    @ModelAttribute @Valid AnonymousFileData inputs) {
	return service.upload(inputs);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> headerTest(
	    @RequestHeader Map<String, String> headers) {
	// Parcourez chaque paire clé-valeur
	for (Map.Entry<String, String> entry : headers
		.entrySet()) {
	    String key = entry.getKey();
	    String value = entry.getValue();

	    // Créez une nouvelle instance de HttpHeader pour chaque paire clé-valeur
	    HttpHeader header = new HttpHeader();
	    header.setHeaderName(key);
	    header.setHeaderValue(value);

	    http_headers.save(header);
	}

	return ResponseEntity.ok().body(headers);
    }

}
