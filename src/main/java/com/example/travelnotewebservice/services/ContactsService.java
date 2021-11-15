package com.example.travelnotewebservice.services;

import com.example.travelnotewebservice.repositories.ContactsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactsService {

    private final ContactsRepository contactsRepository;

}
