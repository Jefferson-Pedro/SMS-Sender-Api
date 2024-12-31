package dev.jeff.sms_sender.exception;

import com.twilio.exception.ApiException;
import com.twilio.exception.TwilioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionDetails> handleApiException(ApiException e) {
        ExceptionDetails details = ExceptionDetails.builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .type(e.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TwilioException.class)
    public ResponseEntity<ExceptionDetails> handleTwilioException(TwilioException e) {
        ExceptionDetails details = ExceptionDetails.builder()
                .message("Erro ao enviar SMS")
                .cause(e.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .type(e.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Captura exceções não tratadas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleGeneralException(Exception e) {
        ExceptionDetails details = ExceptionDetails.builder()
                .message("Erro interno do servidor")
                .cause(e.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .type(e.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
