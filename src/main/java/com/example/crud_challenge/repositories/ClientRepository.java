package com.example.crud_challenge.repositories;

import com.example.crud_challenge.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
