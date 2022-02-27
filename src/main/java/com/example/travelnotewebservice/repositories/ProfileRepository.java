package com.example.travelnotewebservice.repositories;

import com.example.travelnotewebservice.models.Profile;
import com.example.travelnotewebservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByUser(User user);
}
