package com.jobportal.service;

import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String loginUser(User user){

        User existingUser =
                userRepository.findByEmail(user.getEmail())
                        .orElse(null);

        if(existingUser == null){
            return "User not found!";
        }

        if(!existingUser.getPassword()
                .equals(user.getPassword())){
            return "Invalid password!";
        }

        return "Login Successful!";
    }
}