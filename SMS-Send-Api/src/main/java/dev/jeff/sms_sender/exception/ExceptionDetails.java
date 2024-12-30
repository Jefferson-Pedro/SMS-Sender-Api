package dev.jeff.sms_sender.exception;

import java.time.LocalDateTime;

public record ExceptionDetails (
        String message,
        LocalDateTime timestamp,
        int status,
        String exception
    ) {
}
