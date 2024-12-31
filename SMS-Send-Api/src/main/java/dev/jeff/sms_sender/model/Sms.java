package dev.jeff.sms_sender.model;

import dev.jeff.sms_sender.dto.SmsRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String sender;

    @NotNull
    @Min(2)
    @Max(3)
    private Integer ddd;

    @NotNull
    @Pattern(regexp = "^[0-9]{8,9}$")
    private String phoneNumber;

    @NotBlank
    @Size(max = 155)
    private String message;

    private LocalDateTime sentIn;

    public Sms() {}

    public Sms(Integer id, String sender, Integer ddd, String phoneNumber, String message, LocalDateTime sentIn) {
        this.id = id;
        this.sender = sender;
        this.ddd = ddd;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.sentIn = sentIn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentIn() {
        return sentIn;
    }

    public void setSentIn(LocalDateTime sentIn) {
        this.sentIn = sentIn;
    }
}
