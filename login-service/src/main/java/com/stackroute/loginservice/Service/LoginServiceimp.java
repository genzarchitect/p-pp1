package com.stackroute.loginservice.Service;

import com.stackroute.loginservice.Exceptions.EmailNotFound;
import com.stackroute.loginservice.Exceptions.IncorrectPasswordException;
import com.stackroute.loginservice.Exceptions.UserExistsException;
import com.stackroute.loginservice.Exceptions.UserNotFoundException;
import com.stackroute.loginservice.Repo.UserRepo;
import com.stackroute.loginservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceimp implements LoginService {

    @Autowired
    UserRepo repo;

    @Override
    public User registerUser(User user) throws UserExistsException {
        boolean existby= repo.existsById(user.getUseremail());
        if (existby) {
            throw new UserExistsException("User already");
        }

        return this.repo.save(user);
    }
@Override
    public User authenticateUser(String email, String password) throws UserNotFoundException, IncorrectPasswordException {
        boolean exist= repo.existsById(email);
        if (!exist) {
            throw new UserNotFoundException(" User does not exist with given email");
        }
        Optional<User> optUser = repo.findByEmailAndPassword(email, password);
        if (optUser.isEmpty()) {
            throw new IncorrectPasswordException("Password missing");
        }
        return optUser.get();

    }

    @Override
    public User forgotPassword(String email, User user) throws EmailNotFound {
            Optional<User> opt = repo.findByEmail(email);

            if (opt.isPresent()) {
                User users = opt.get();

                users.setPassword(user.getPassword());

                repo.save(users);
                return users;

            }
            throw new EmailNotFound("EmailNotFound");

        }



}