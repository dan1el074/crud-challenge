package com.example.crud_challenge.dtos.errors;

public class FieldMessage {
    private String field;
    private String error;

    public FieldMessage(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
