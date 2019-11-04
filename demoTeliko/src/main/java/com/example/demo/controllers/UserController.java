package com.example.demo.controllers;


import com.example.demo.pojos.AllUserResponse;
import com.example.demo.pojos.GetAllToursResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//o controller milaei mono me service

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/allUsers")
    public AllUserResponse allUserResponse() {

        return new AllUserResponse(service.getAllUsers());
    }
    //ftiaxnume ena Response

    @GetMapping("/getUsersByStatus/{userStatus}")
    public AllUserResponse getUsersByStatus(@PathVariable String userStatus) {
        return new AllUserResponse(service.getUserByStatus(userStatus));

             }
    }




