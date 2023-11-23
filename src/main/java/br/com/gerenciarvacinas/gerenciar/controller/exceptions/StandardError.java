package br.com.gerenciarvacinas.gerenciar.controller.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class StandardError {
    private Instant dataHora;
    private Integer status;
    private String mensagem;
    private String path;

    public StandardError() {
    }

    public StandardError(HttpStatus httpStatus, String mensagem) {
    }

    public StandardError(HttpStatus httpStatus, String localizedMessage, String errorOccurred) {
    }

    public StandardError(String message, String description) {
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}