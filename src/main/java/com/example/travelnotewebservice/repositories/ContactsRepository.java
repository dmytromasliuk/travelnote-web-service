package com.example.travelnotewebservice.repositories;

import com.example.travelnotewebservice.models.Contacts;
import com.example.travelnotewebservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

}
