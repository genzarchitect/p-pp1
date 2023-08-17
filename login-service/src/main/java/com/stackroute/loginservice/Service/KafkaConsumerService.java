package com.stackroute.loginservice.Service;

import com.stackroute.loginservice.model.UserDTO;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "Arena",groupId = "Group1",containerFactory = "dtoListener")
    public void listen(UserDTO dto)
    {
        System.out.println("Received"+dto);
    }
}
