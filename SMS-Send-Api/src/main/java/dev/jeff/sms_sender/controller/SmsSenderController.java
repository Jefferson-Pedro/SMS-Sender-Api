package dev.jeff.sms_sender.controller;

import dev.jeff.sms_sender.dto.SmsRequest;
import dev.jeff.sms_sender.model.Sms;
import dev.jeff.sms_sender.service.ISmsSenderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SmsSenderController {

    private final ISmsSenderService smsService;

    public SmsSenderController(@Qualifier("twilio") ISmsSenderService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest smsRequest){

        smsService.sendSms(smsRequest);
        return ResponseEntity.ok().body("Mensagem enviada com sucesso!");
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<Sms>> findAll (){
        List<Sms> list = smsService.findAll();
        if(!list.isEmpty()){
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Integer id){

        if (smsService.delete(id)){
            return ResponseEntity.ok().body("Sms deletado com sucesso!");
        }
        return ResponseEntity.internalServerError().body("Aconteceu um erro ao deletar o sms");
    }
}
