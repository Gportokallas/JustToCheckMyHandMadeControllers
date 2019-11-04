package com.example.demo.services;



import com.example.demo.mappers.UserMapper;

import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//apo to repository pernume tus users,kai ta pername se mia lista

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    public List<UserResponse>
    getAllUsers() {
        Iterable<User> retrievedUsers = repository.findAll();
        List<UserResponse> users = new ArrayList<>();

        for (User user : retrievedUsers) {
            users.add(mapper.mapUserResponseFromUser(user));
        }

        return users;
/*        retrievedTours.forEach((tour)-> {

        });*/
    }

    public List<UserResponse> getUserByStatus(String userStatus) {
        Iterable<User> retrievedUsers = repository.findAll();
        List<UserResponse> users = new ArrayList<>();
        for (User user : retrievedUsers) {
            if (String.valueOf(user.getStatus()).equalsIgnoreCase(userStatus) ) {
                users.add(mapper.mapUserResponseFromUser(user));
            }
        }
        return users;

    }
}
