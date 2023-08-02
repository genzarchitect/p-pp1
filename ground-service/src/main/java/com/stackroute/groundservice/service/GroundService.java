package com.stackroute.groundservice.service;

import com.stackroute.groundservice.model.Ground;

import java.util.List;

public interface GroundService {

    public boolean addGround(Ground ground);
    public List<Ground> getAllGround();

    public List<Ground> getGroundByCategory(String category);

}
