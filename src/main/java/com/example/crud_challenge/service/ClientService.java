package com.example.crud_challenge.service;

import com.example.crud_challenge.dtos.ClientDTO;
import com.example.crud_challenge.entities.Client;
import com.example.crud_challenge.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }
}
