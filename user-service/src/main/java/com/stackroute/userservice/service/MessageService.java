package com.stackroute.userservice.service;

import com.stackroute.userservice.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private KafkaTemplate<String,String> KafkaTemplate;
    public void sendMessage(UserDTO message)
    {
        KafkaTemplate.send("Arena",message.toString());
        System.out.println(message.toString());
    }
}
