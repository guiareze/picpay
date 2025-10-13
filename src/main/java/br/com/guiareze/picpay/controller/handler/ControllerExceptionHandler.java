package br.com.guiareze.picpay.controller.handler;

import br.com.guiareze.picpay.persistence.exception.PersistenceException;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ProblemDetail> handlePersistenceException(PersistenceException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(500);
        problemDetail.setTitle("Persistence Error");
        problemDetail.setDetail(exception.getMessage());
        return ResponseEntity.status(500).body(problemDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGenericException(Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(500);
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setDetail("An unexpected error occurred.");
        return ResponseEntity.status(500).body(problemDetail);
    }

}
