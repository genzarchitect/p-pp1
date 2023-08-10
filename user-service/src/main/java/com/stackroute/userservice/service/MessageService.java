package com.stackroute.userservice.service;

import com.stackroute.userservice.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private KafkaTemplate<String,UserDTO> kafkaTemplate;

    //private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    public MessageService(KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private final static String TOPIC_NAME = "Arena";
    public void sendMessage(UserDTO message)
    {
        kafkaTemplate.send(TOPIC_NAME,message);
        //System.out.println(message.toString());
    }

    /*@Autowired
    private KafkaTemplate<String,String> KafkaTemplate;
    public void sendMessage(UserDTO message)
    {
        KafkaTemplate.send("Arena",message.toString());
        System.out.println(message.toString());
    }*/

}
