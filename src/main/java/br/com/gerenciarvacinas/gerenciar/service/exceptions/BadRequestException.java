package br.com.gerenciarvacinas.gerenciar.service.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}