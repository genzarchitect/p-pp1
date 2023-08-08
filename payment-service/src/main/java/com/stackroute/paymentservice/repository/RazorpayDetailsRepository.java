package com.stackroute.paymentservice.repository;

import com.stackroute.paymentservice.model.RazorpayDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazorpayDetailsRepository extends MongoRepository<RazorpayDetails, String> {}
