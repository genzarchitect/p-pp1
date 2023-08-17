package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.EmptyUserException;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repo;

    @Autowired
    MessageService message;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = repo.findAll();
        if (userList.size()>0){
            return userList;
        }
        throw new EmptyUserException("There is no user present in DB");
    }



    @Override
    public User addUsersToDB(User user) throws UserAlreadyExistsException{
        boolean existby = repo.existsById(user.getUserEmail());
        if (existby)
        {
            throw new UserAlreadyExistsException("User already exists");
        }
        UserDTO userDTO = new UserDTO( user.getUserEmail(),user.getUserPassword(),user.getUserType());
        message.sendMessage(userDTO);
        return this.repo.save(user);
    }



    @Override
    public User getUserByEmail(String userEmail) {
        Optional<User> userList = repo.findById(userEmail);
        if(userList.isPresent()){
            return userList.get();
        }
        throw new UserNotFoundException("No User Found");
    }


    public boolean deleteUser(String userEmail){
        User user = getUserByEmail(userEmail);
        if (user!=null)
        {
            repo.deleteById(userEmail);
            return true;
        }

        throw new UserNotFoundException("User not exist");
    }

    @Override
    public User updateUserByEmail(String userEmail, User updatedUser) {
        Optional<User> extinguisheropt = repo.findById(userEmail);

        if (extinguisheropt.isPresent()) {
            User existinguser = extinguisheropt.get();
            existinguser.setUserName(updatedUser.getUserName());
            existinguser.setUserMobile(updatedUser.getUserMobile());
            existinguser.setUserGender(updatedUser.getUserGender());
            existinguser.setUserType(updatedUser.getUserType());
            existinguser.setUserEmail(updatedUser.getUserEmail());
            existinguser.setUserPassword(updatedUser.getUserPassword());
            existinguser.setUserLocation(updatedUser.getUserLocation());


            repo.save(existinguser);
            return existinguser;
        }
        throw new UserNotFoundException("Please select the user to update");
    }

}