package com.example.travelnotewebservice.controllers;

import com.example.travelnotewebservice.controllers.requests.ProfileUpdateRequest;
import com.example.travelnotewebservice.controllers.responses.ProfileDetailsResponse;
import com.example.travelnotewebservice.services.ProfileService;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProfileController {

    private final ProfileService  profileService;

    @GetMapping(path = "/api/{userId}/profile", produces = "application/json")
    @ResponseBody
    public ProfileDetailsResponse getProfileDetails(@PathVariable ("userId") Long userId) {
        return profileService.getProfileDetails(userId);
    }

    @PutMapping(path = "/api/{userId}/profile")
    public String update(
            @PathVariable ("userId") Long userId,
            @RequestBody ProfileUpdateRequest request) {

        return profileService.updateProfile(userId, request);
    }
}
