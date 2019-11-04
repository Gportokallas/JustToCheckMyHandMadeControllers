package com.example.demo.pojos;


import java.util.List;

public class AllUserResponse {

    private List<UserResponse> userResponses;
    //ftiaxnume mia lista me responses

    //ftiaxnume constructor kai meta getter setter

    public AllUserResponse(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }

    public List<UserResponse> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }


}
