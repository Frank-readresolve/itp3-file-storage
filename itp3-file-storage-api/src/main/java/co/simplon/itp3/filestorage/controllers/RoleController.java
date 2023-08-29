package co.simplon.itp3.filestorage.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.RoleData;
import co.simplon.itp3.filestorage.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService service;

    public RoleController(RoleService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(
	    @RequestBody @Valid RoleData inputs) {
	service.create(inputs);
    }

}
