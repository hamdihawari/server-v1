package com.hamdihawari.server.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Get all contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Get a contact by ID
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    // Create or update a contact
    public Contact createOrUpdateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // Delete a contact by ID
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    // Get contacts by language
    public List<Contact> getContactsByLanguage(String language) {
        // Assuming your Contact entity has a 'language' field
        return contactRepository.findByLanguage(language);
    }
}
