package org.mannayakasha.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

@javax.persistence.Entity
@Table(name = "users")
public class User extends Entity {
	
	@Column(name = "username")
    private String username;

	@Column(name = "email")
    private String email;

	@Column(name = "password")
    private String password;
	
	@Transient
    private String confirmPassword;
	
    @Column(name = "active")
    private boolean active;
	
	@Column(name = "avatar")
	private String avatar;
	
	public User() {}
	
	public User(Integer id, String username, String email, String password, boolean active, String avatar) {
		super(id);
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
		this.avatar = avatar;
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
	
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
	
	public String getAvatar() {
		return this.avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}