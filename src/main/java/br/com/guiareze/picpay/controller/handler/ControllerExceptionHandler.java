package br.com.guiareze.picpay.controller.handler;

import br.com.guiareze.picpay.core.exception.AccountValidationException;
import br.com.guiareze.picpay.core.exception.TransferOperationException;
import br.com.guiareze.picpay.core.exception.UserValidationException;
import br.com.guiareze.picpay.persistence.exception.PersistenceException;
import br.com.guiareze.picpay.rest.exception.RestIntegrationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ProblemDetail> handlePersistenceException(PersistenceException exception) {
        log.error("PersistenceException", exception);
        return buildResponse(500, "Persistence Error", exception.getMessage());
    }

    @ExceptionHandler(AccountValidationException.class)
    public ResponseEntity<ProblemDetail> handleAccountValidationException(AccountValidationException exception) {
        log.error("AccountValidationException", exception);
        return buildResponse(422, "Account Validation Error", exception.getMessage());
    }

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<ProblemDetail> handleUserValidationException(UserValidationException exception) {
        log.error("UserValidationException", exception);
        return buildResponse(422, "User Validation Error", exception.getMessage());
    }

    @ExceptionHandler(RestIntegrationException.class)
    public ResponseEntity<ProblemDetail> handleRestIntegrationException(RestIntegrationException exception) {
        log.error("RestIntegrationException", exception);
        return buildResponse(502, "External Service Error", exception.getMessage());
    }

    @ExceptionHandler(TransferOperationException.class)
    public ResponseEntity<ProblemDetail> handleTransferOperationException(TransferOperationException exception) {
        log.error("TransferOperationException", exception);
        return buildResponse(422, "Transfer Operation Error", exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGenericException(Exception exception) {
        log.error("Exception", exception);
        return buildResponse(500, "Internal Server Error", "An unexpected error occurred.");
    }

    private ResponseEntity<ProblemDetail> buildResponse(int status, String title, String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle(title);
        problemDetail.setDetail(detail);
        return ResponseEntity.status(status).body(problemDetail);
    }
}
