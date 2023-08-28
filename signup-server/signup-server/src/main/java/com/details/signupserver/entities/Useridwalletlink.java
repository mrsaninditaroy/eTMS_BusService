package com.details.signupserver.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useridwalletlinks")
public class Useridwalletlink {
    @Id
    @Column(name = "userid", nullable = false, length = 50)
    private String userid;
    
    @Column(name = "username", length = 10)
    private String username;

    @Column(name = "walletid", length = 10)
    private String walletid;    

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}