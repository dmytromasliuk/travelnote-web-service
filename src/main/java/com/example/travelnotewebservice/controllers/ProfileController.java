package com.example.travelnotewebservice.controllers;

import com.example.travelnotewebservice.controllers.requests.ProfileUpdateRequest;
import com.example.travelnotewebservice.controllers.responses.ProfileDetailsResponse;
import com.example.travelnotewebservice.models.User;
import com.example.travelnotewebservice.services.ProfileService;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProfileController {

    private final ProfileService  profileService;

    @GetMapping(path = "/api/profile", produces = "application/json")
    @ResponseBody
    public ProfileDetailsResponse getProfileDetails(@AuthenticationPrincipal User user) {
        return profileService.getProfileDetails(user);
    }

    @PutMapping(path = "/api/profile")
    public String update(
            @AuthenticationPrincipal User user,
            @RequestBody ProfileUpdateRequest request) {

        return profileService.updateProfile(user, request);
    }
}
