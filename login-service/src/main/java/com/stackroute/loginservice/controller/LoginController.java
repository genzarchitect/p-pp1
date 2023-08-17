package com.stackroute.loginservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.loginservice.Exceptions.EmailNotFound;
import com.stackroute.loginservice.Exceptions.IncorrectPasswordException;
import com.stackroute.loginservice.Exceptions.UserExistsException;
import com.stackroute.loginservice.Exceptions.UserNotFoundException;
import com.stackroute.loginservice.Service.LoginService;
import com.stackroute.loginservice.Service.TokenGeneratorService;
//import com.stackroute.loginservice.kafka.KafkaConsumer;
import com.stackroute.loginservice.model.User;
import com.stackroute.loginservice.model.UserCredential;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
    @RequestMapping("/arena")
    public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenGeneratorService tokenGeneratorService;
    public ResponseEntity<?> responseEntity;
//    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);


    @GetMapping("/welcome")
    public String welcome() {
        return "hello";
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserExistsException {
        try {
            User users = loginService.registerUser(user);
            responseEntity = new ResponseEntity<>(users, HttpStatus.CREATED);
        } catch (UserExistsException u) {
            responseEntity = new ResponseEntity<>("User Already Exists.", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserCredential credential) throws UserNotFoundException, IncorrectPasswordException {
        try {
            User user = loginService.authenticateUser(credential.getUseremail(), credential.getPassword());
            Map<String, String> token = tokenGeneratorService.generateToken(credential);
            responseEntity = new ResponseEntity<>(token, HttpStatus.FOUND);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<>("Not User By this mail", HttpStatus.NOT_FOUND);
        } catch (IncorrectPasswordException i) {
            responseEntity = new ResponseEntity<>("Incorrect Password", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/forget/{email}")
    public ResponseEntity<?> ForgotPassword(@PathVariable("email") String email, @RequestBody User user) {
        try {
            User userr = loginService.forgotPassword(email, user);
            responseEntity = new ResponseEntity<>(userr, HttpStatus.ACCEPTED);
        } catch (EmailNotFound e) {
            responseEntity = new ResponseEntity<>("Email not selected", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

//    @KafkaListener(topics = "topic1", groupId = "groupone")
//    public void listen(String message) throws JsonProcessingException {
//        ObjectMapper user=new ObjectMapper();
//        User user2 =user.readValue(message,User.class);
//        log.info("Message received:{}", message);

}







