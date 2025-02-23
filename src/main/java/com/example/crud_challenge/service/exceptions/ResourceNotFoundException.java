package com.example.crud_challenge.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Recurso não encontrado!");
    }
}
