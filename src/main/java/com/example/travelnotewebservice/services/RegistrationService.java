package com.example.travelnotewebservice.services;

import com.example.travelnotewebservice.controllers.requests.RegistrationRequest;
import com.example.travelnotewebservice.models.User;
import com.example.travelnotewebservice.models.UserRole;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Email is not valid...");
        }
        return userService.signUpUser(
                new User (
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
