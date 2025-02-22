package com.example.crud_challenge.dtos;

import com.example.crud_challenge.entities.Client;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO() {}

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ClientDTO dto = (ClientDTO) o;
        return Objects.equals(getId(), dto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
