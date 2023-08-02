package com.stackroute.groundservice.repository;

import com.stackroute.groundservice.model.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroundRepo extends JpaRepository<Ground,Integer> {
    List<Ground> findByCategories(String categories);
}
