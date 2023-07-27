package co.simplon.itp3.filestorage.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.itp3.filestorage.dtos.SubscriptionData;
import co.simplon.itp3.filestorage.services.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody @Valid SubscriptionData inputs) {
	service.create(inputs);
    }
}
