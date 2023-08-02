package com.stackroute.groundservice.controller;


import com.stackroute.groundservice.exception.GroundAlreadyExistsException;
import com.stackroute.groundservice.model.Ground;
import com.stackroute.groundservice.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/grounds")
public class GroundController {

    ResponseEntity<?> responseEntity;

    @Autowired
    GroundService groundService;

    @GetMapping("/allgrounds")
    public ResponseEntity<?> getAllGrounds(){
        return new ResponseEntity<>(groundService.getAllGround(), HttpStatus.OK);
    }

    @GetMapping("/addground")
    public ResponseEntity<?> addGround(@RequestBody Ground ground){
        try {
            if(groundService.addGround(ground)){
               responseEntity =  new ResponseEntity<>("Ground Addded",HttpStatus.CREATED);
            }
        }
        catch (GroundAlreadyExistsException e){
            responseEntity = new ResponseEntity<>("Ground Already Exists",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

}
