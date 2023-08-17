package com.stackroute.loginservice.Service;

import com.stackroute.loginservice.model.UserCredential;

import java.util.Map;

public interface TokenGeneratorService {

    Map<String,String> generateToken(UserCredential credential);
}
