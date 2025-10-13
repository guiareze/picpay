package br.com.guiareze.picpay.persistence.exception;

public class PersistenceException extends RuntimeException{

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(String message) {
        super(message);
    }

}
