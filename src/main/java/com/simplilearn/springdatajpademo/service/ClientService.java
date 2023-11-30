package com.simplilearn.springdatajpademo.service;

import com.simplilearn.springdatajpademo.model.Client;
import com.simplilearn.springdatajpademo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Pavel Tikhomirov
 * @since 2023-11-30
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findById(Long id) {
        return this.clientRepository.findById(id);
    }
}
