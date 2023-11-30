package com.simplilearn.springdatajpademo.controller;

import com.simplilearn.springdatajpademo.model.Client;
import com.simplilearn.springdatajpademo.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavel Tikhomirov
 * @since 2023-11-30
 */
@RestController("v1")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/client/{id}")
    public Client getUser(@PathVariable("id") Long id) {
        return this.clientService.findById(id).get();
    }

}
