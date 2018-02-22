package org.mannayakasha.entity;

import javax.persistence.*;

import org.springframework.security.crypto.password.PasswordEncoder;

@javax.persistence.Entity
@Table(name = "users")
public class User extends Entity {

	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
    private String username;

	@Column(name = "email")
    private String email;

	@Column(name = "password")
    private String password;
	
	/*@Transient
    private String confirmPassword;
	
    @Column(name = "active")
    private boolean active;
	
	@Column(name = "avatar")
	private String avatar;*/
	
	public User() {}
	
	public User(Integer id, String name, String username, String email, String password) {
		super(id);
        this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}