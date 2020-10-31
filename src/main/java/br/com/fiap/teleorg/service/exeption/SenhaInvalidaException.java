package br.com.fiap.teleorg.service.exeption;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException() {
        super("Senha Invalida");
    }
}
