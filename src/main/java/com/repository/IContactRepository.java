package com.repository;

import com.datamodel.Contact;
import com.datamodel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {
    Contact findByUser(User user);
}
