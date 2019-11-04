package com.example.demo.mappers;


import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse mapUserResponseFromUser(User user) {
        return new UserResponse(
              user.getId(),
              user.getFirstName(),
              user.getLastName(),
              user.getNumberOfBookings(),
              user.getStatus()
        );
    }

}
