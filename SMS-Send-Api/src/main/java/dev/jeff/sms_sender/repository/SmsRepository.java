package dev.jeff.sms_sender.repository;

import dev.jeff.sms_sender.model.Sms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<Sms, Integer> {

}
