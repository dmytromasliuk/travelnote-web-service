package com.example.travelnotewebservice.services;

import com.example.travelnotewebservice.controllers.requests.ProfileUpdateRequest;
import com.example.travelnotewebservice.controllers.responses.ProfileDetailsResponse;
import com.example.travelnotewebservice.models.*;
import com.example.travelnotewebservice.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final ContactsRepository contactsRepository;
    private final CountryRepository countryRepository;

    public ProfileDetailsResponse getProfileDetails(    Long userId){
        Profile profile = profileRepository.findByUser(userRepository.getById(userId));
        return new ProfileDetailsResponse(
                profile.getUser().getFirstName(),
                profile.getUser().getLastName(),
                profile.getContacts().getEmail(),
                profile.getContacts().getPhone(),
                profile.getCountry().getName()
        );
    }

    @Transactional
    public String updateProfile(Long userId, ProfileUpdateRequest request){

        Profile profile = profileRepository.findByUser(userRepository.getById(userId));
        Contacts contacts = profile.getContacts();
        contacts.setPhone(request.getPhone());
        profile.setCountry(countryRepository.getById(request.getCountryId()));
        profileRepository.save(profile);
        return "Profile updated successfully!";
    }


}
