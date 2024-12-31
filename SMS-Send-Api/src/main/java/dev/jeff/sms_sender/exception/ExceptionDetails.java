package dev.jeff.sms_sender.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {

    private final String message;
    private final String cause;
    private final LocalDateTime timestamp;
    private final Integer status;
    private final String type;

    private ExceptionDetails(Builder builder) {
        this.message = builder.message;
        this.cause = builder.cause;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.type = builder.type;
    }

    // Getters apenas para manter a imutabilidade
    public String getMessage() {
        return message;
    }

    public String getCause() {
        return cause;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;
        private String cause;
        private LocalDateTime timestamp;
        private Integer status;
        private String type;

        private Builder() {
            // Construtor privado para forçar o uso do builder()
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder cause(String cause) {
            this.cause = cause;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public ExceptionDetails build() {
            // Validações antes de construir o objeto
            if (timestamp == null) {
                timestamp = LocalDateTime.now();
            }

            if (message == null || message.trim().isEmpty()) {
                throw new IllegalStateException("Message cannot be null or empty");
            }

            if (status == null) {
                throw new IllegalStateException("Status cannot be null");
            }

            return new ExceptionDetails(this);
        }
    }
}
