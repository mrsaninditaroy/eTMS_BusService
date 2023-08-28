package com.details.signupserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.details.signupserver.entities.Credential;

public interface CredentialRepository extends JpaRepository<Credential, String>
{

}