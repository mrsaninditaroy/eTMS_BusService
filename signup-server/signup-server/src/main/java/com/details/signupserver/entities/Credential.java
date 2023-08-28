package com.details.signupserver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")
public class Credential {
    @Id
    @Column(name = "userid", nullable = false, length = 50)
    private String id;
    
    @Column(name = "username", nullable = false, length = 50)
    private String usename;


    @Column(name = "password", length = 50)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

}