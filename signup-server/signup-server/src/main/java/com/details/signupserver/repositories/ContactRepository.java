package com.details.signupserver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.details.signupserver.entities.*;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	
}
