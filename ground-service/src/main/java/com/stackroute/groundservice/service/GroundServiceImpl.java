package com.stackroute.groundservice.service;

import com.stackroute.groundservice.exception.GroundNotFoundException;
import com.stackroute.groundservice.model.Ground;
import com.stackroute.groundservice.repository.GroundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundServiceImpl implements GroundService{

    @Autowired
    GroundRepo groundRepo;
    @Override
    public boolean addGround(Ground ground) {
        boolean check = false;
        if(ground!=null){
            groundRepo.save(ground);
            check = true;
        }
        return check;
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

}
