package br.com.gerenciarvacinas.gerenciar.service.exceptions;
public class DuplicateKeyException extends RuntimeException {
    public DuplicateKeyException(String msg){
        super(msg);
    }
}
