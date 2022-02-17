package com.dataservice;

import com.datamodel.*;
import com.repository.IContactRepository;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService implements IContactService{

    @Autowired
    IContactRepository iContactRepository;

    @Override
    public Contact saveContact(Contact contact, User user, Address address)  {
        contact.setAddress(address);
        contact.setUser(user);
        return iContactRepository.save(contact);
    }

    public Contact findByUser(User user){
        return iContactRepository.findByUser(user);
    }

}
