package com.stackroute.groundservice.service;

import com.stackroute.groundservice.model.Ground;

import java.util.List;

public interface GroundService {

    public boolean addGround(Ground ground);
    public List<Ground> getAllGround();

    public List<Ground> getGroundByCategory(String category);
    public Ground getGroundById(int groundId);
    public List<Ground> getGroundByOwnerEmail(String email);

    public List<Ground> getAllOpenGround();
    public Ground changeStatusofGround(Ground.Status status,int groundId);
    List<Ground> getAllGroundByCity(String city);

}
