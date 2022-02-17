package com.dataservice;

import com.datamodel.Address;
import com.datamodel.Contact;
import com.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IContactService{
    Contact saveContact(Contact contact, User user, Address address);
}
