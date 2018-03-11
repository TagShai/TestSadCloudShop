package org.mannayakasha.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@javax.persistence.Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
public class User extends Entity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "username")
    private String username;

	@Column(name = "email")
    private String email;

	@Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "wishes", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> wishes;

    @OneToMany(mappedBy = "user")//, cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Set<Order> orders;
	
	/*@Transient
    private String confirmPassword;
	
    @Column(name = "active")
    private boolean active;
	
	@Column(name = "avatar")
	private String avatar;*/
	
	public User() {}

	public User(Integer id, String name, String username, String email, String password, Set<Product> wishes, Set<Order> orders) {
		super(id);
        this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.wishes = wishes;
        this.orders = orders;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public Set<Product> getWishes() {
        return wishes;
    }

    public void setWishes(Set<Product> wishes) {
        this.wishes = wishes;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", wishes=" + wishes +
                ", orders=" + orders +
                '}';
    }
}