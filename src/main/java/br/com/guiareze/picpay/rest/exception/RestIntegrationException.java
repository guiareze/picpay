package br.com.guiareze.picpay.rest.exception;

public class RestIntegrationException extends RuntimeException{

    public RestIntegrationException(String message) {
        super(message);
    }

    public RestIntegrationException(String message, Throwable cause) {
        super(message, cause);
    }

}
