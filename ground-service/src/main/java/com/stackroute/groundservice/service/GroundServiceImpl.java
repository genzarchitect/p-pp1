package com.stackroute.groundservice.service;

import com.stackroute.groundservice.exception.GroundNotFoundException;
import com.stackroute.groundservice.exception.NoOpenGroundFound;
import com.stackroute.groundservice.model.Ground;
import com.stackroute.groundservice.repository.GroundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class GroundServiceImpl implements GroundService{

    @Autowired
    GroundRepo groundRepo;
    @Autowired
    GridFsService gridFsService;

    @Override
    public boolean addGround(Ground ground) {
        boolean check = false;
        if(ground!=null){
            groundRepo.save(ground);
            check = true;
        }
        return check;
    }

    public String addImageToGround(int groundId, MultipartFile file) {
        Ground ground = groundRepo.findById(groundId).orElse(null);
        if (ground != null) {
            try {
                String imageId = gridFsService.store(file);
                ground.setGroundImage(imageId);
                groundRepo.save(ground);
                return "Image added successfully to ground: " + groundId;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Error adding image or ground not found";
    }



    @Override
    public List<Ground> getAllGround() {
        List<Ground> allGrounds = groundRepo.findAll();
        if(allGrounds.size()>0){
            return allGrounds;
        }
        throw new GroundNotFoundException("No ground Found");
    }

    @Override
    public List<Ground> getGroundByCategory(String category) {
        List<Ground> groundListByCategory = groundRepo.findByCategories(category);
        if(groundListByCategory.size()>0){
            return groundListByCategory;
        }
        throw new GroundNotFoundException("No Ground Found By this Category");
    }

    @Override
    public Ground getGroundById(int id) {
       Optional<Ground> groundOptional =  groundRepo.findById(id);
       if(groundOptional.isPresent()){
           return groundOptional.get();
       }
       throw new GroundNotFoundException("No ground exists with this id");
    }

    @Override
    public List<Ground> getGroundByOwnerEmail(String email) {
        List<Ground> groundList = groundRepo.findByGroundOwnerEmail(email);
        if(groundList.size()>0){
            return groundList;
        }
        throw new GroundNotFoundException("No Ground Found");
    }

    @Override
    public List<Ground> getAllOpenGround() {
        List<Ground> openGroundList = groundRepo.findByStatus(Ground.Status.OPEN);
        if(openGroundList.size()>0){
            return openGroundList;
        }
        throw new NoOpenGroundFound("No open Ground is available");
    }

    @Override
    public Ground changeStatusofGround(Ground.Status status, int groundId) {
       Optional<Ground> groundOptional = groundRepo.findById(groundId);
       if(!groundOptional.isPresent()){
            throw new GroundNotFoundException("No ground found with this id");
       }
       Ground ground = groundOptional.get();
       ground.setStatus(status);
       groundRepo.save(ground);
       return ground;
    }

    @Override
    public List<Ground> getAllGroundByCity(String city) {
       List<Ground> allGroundsByCity = groundRepo.findByGroundAddress_City(city);
       if(allGroundsByCity.size()>0){
           return allGroundsByCity;
       }
       throw new GroundNotFoundException("No ground found nearby");
    }

    public boolean deleteGround(int id) {
        boolean check = true;
        Optional<Ground> groundOptional = groundRepo.findById(id);
        if(!groundOptional.isPresent()){
           check = false;
        }
        groundRepo.deleteById(id);
        return check;
    }

    @Override
    public Ground updateGround(int id, Ground updatedGround) {
        Optional<Ground> groundOptional = groundRepo.findById(id);
        if(!groundOptional.isPresent()){
            throw new GroundNotFoundException("No ground found with this id");
        }
        Ground existingGround = groundOptional.get();
        existingGround.setGroundName(updatedGround.getGroundName());
        existingGround.setCategories(updatedGround.getCategories());
        existingGround.setStatus(updatedGround.getStatus());
        existingGround.setGroundOwnerEmail(updatedGround.getGroundOwnerEmail());
        existingGround.setGroundAddress(updatedGround.getGroundAddress());
        existingGround.setGroundImage(updatedGround.getGroundImage());
        groundRepo.save(existingGround);
        return existingGround;
    }


}
