package com.example.contactmanagerapp;

import java.util.List;

public class Repository {
    // The Available Data Sources:
    // - ROOM Database

    private final ContactDao contactDao;

    public Repository(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    // Methods in DAO being executed from Repository
    public void addContact(Contacts contact) {
        contactDao.insert(contact);
    }

    public void deleteContact(Contacts contact) {
        contactDao.delete(contact);
    }

    public List<Contacts> getAllContacts() {
        contactDao.getAllContacts();
    }
}
