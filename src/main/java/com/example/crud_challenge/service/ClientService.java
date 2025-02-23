package com.example.crud_challenge.service;

import com.example.crud_challenge.dtos.ClientDTO;
import com.example.crud_challenge.entities.Client;
import com.example.crud_challenge.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> dto = clientRepository.findById(id);
        return new ClientDTO(dto.get());
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client client = new Client();
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(ClientDTO dto, Long id) {
        Client client = new Client();
        client.setId(id);
        copyDtoToEntity(dto, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new RuntimeException("Recurso não encontrado!");
        }
        clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
