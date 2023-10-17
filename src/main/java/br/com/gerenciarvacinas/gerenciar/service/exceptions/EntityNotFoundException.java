package br.com.gerenciarvacinas.gerenciar.service.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String msg){
        super(msg);
    }

}