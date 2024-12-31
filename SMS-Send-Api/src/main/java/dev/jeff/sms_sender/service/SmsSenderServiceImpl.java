package dev.jeff.sms_sender.service;

import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import dev.jeff.sms_sender.config.TwilioConfg;
import dev.jeff.sms_sender.dto.SmsMapper;
import dev.jeff.sms_sender.dto.SmsRequest;
import dev.jeff.sms_sender.exception.RestExceptionHandler;
import dev.jeff.sms_sender.model.Sms;
import dev.jeff.sms_sender.repository.SmsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("twilio")
public class SmsSenderServiceImpl implements ISmsSenderService {

    public final TwilioConfg twilioConfg;
    public final SmsRepository repository;
    public final SmsMapper smsMapper;

    public SmsSenderServiceImpl(TwilioConfg twilioConfg, SmsRepository repository, SmsMapper smsMapper) {
        this.twilioConfg = twilioConfg;
        this.repository = repository;
        this.smsMapper = smsMapper;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {

        try {
            String from = "De: " + smsRequest.sender() + "\n";
            Message message = Message
                    .creator(
                            new PhoneNumber("+55" + smsRequest.ddd() + smsRequest.phoneNumber()),
                            new PhoneNumber(twilioConfg.getTrialNumber()),
                            from + smsRequest.message()
                    )
                    .create();
            this.save(smsRequest);
        } catch (TwilioException e) {
            throw new RuntimeException("Erro ao enviar SMS:" + e);
        }

    }

    @Override
    public Sms save(SmsRequest smsRequest) {
        Sms sms = smsMapper.toEntity(smsRequest);
        return repository.save(sms);
    }

    @Override
    public List<Sms> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Sms> res = repository.findById(id);
        if(res.isPresent()){
            repository.deleteById(id);
            System.out.println("Objeto excluido com sucesso!");
            return true;
        }
        System.err.println("Aconteceu um erro ao excluir o objeto!");
        return false;
    }
}
