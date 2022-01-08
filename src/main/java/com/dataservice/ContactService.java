package com.dataservice;

import com.datamodel.Contact;
import com.datamodel.User;
import com.repository.IContactRepository;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    IContactRepository iContactRepository;

    public Contact create(Contact contact) { return iContactRepository.save(contact); }

}
