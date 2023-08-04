package com.stackroute.groundservice.controller;


import com.stackroute.groundservice.exception.GroundAlreadyExistsException;
import com.stackroute.groundservice.exception.GroundNotFoundException;
import com.stackroute.groundservice.exception.NoOpenGroundFound;
import com.stackroute.groundservice.model.Ground;
import com.stackroute.groundservice.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroundController {

    ResponseEntity<?> responseEntity;

    @Autowired
    GroundService groundService;
    @GetMapping("/welcome")
    public String welcome(){
        return "hello";
    }

    @GetMapping("/allgrounds")
    public ResponseEntity<?> getAllGrounds(){
        try {
            if(groundService.getAllGround().size()>0){
                responseEntity =  new ResponseEntity<>(groundService.getAllGround(),HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PostMapping("/addground")
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
    @PostMapping("/addImage/{groundId}")
    public String addImageToGround(@PathVariable int groundId, @RequestParam("file") MultipartFile file) {
        return groundService.addImageToGround(groundId, file);
    }


    @GetMapping("/groundId/{id}")
    public ResponseEntity<?> getGroundById(@PathVariable("id") int id){
        try {
            Ground ground = groundService.getGroundById(id);
            if(ground!=null){
                responseEntity = new ResponseEntity<>(ground,HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/ground/{email}")
    public ResponseEntity<?> getGroundByOwner(@PathVariable("email") String email){
        try {
            List<Ground> groundList = groundService.getGroundByOwnerEmail(email);
            if(groundList.size()>0){
                responseEntity = new ResponseEntity<>(groundList,HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
    @GetMapping("/status/open")
    public ResponseEntity<?> getAllOpenGrounds() {
        return new ResponseEntity<>(groundService.getAllOpenGround(), HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Ground>> getGroundsByCategory(@PathVariable("category") String category) {
        return new ResponseEntity<>(groundService.getGroundByCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/ground/{id}")
    public ResponseEntity<?> deleteGround(@PathVariable int id) {
        try {
          boolean check=  groundService.deleteGround(id);
            if(check){
                responseEntity = new ResponseEntity<>("Ground Deleted Successfully",HttpStatus.OK);
            }
        }
        catch (GroundNotFoundException e){
            responseEntity = new ResponseEntity<>("No Ground Found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
