package br.com.gerenciarvacinas.gerenciar.service.exceptions;

public class VacinaExistenteException extends RuntimeException {
    public VacinaExistenteException(String message) {
        super(message);
    }
}
