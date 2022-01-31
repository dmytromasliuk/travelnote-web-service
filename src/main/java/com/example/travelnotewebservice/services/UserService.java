package com.example.travelnotewebservice.services;

import com.example.travelnotewebservice.models.Contacts;
import com.example.travelnotewebservice.models.Profile;
import com.example.travelnotewebservice.models.User;
import com.example.travelnotewebservice.repositories.ContactsRepository;
import com.example.travelnotewebservice.repositories.ProfileRepository;
import com.example.travelnotewebservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final ContactsRepository contactsRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("User with \"" + s + "\" username, not found..."));
    }

    public String signUpUser(User user) {
        boolean userExists = userRepository.findUserByEmail(user.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("Email already taken...");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Contacts contacts = new Contacts(user.getEmail());
        userRepository.save(user);
        contactsRepository.save(contacts);
        profileRepository.save(new Profile(user, contacts));

        return "User registration successfully done!";
    }

}
