package org.alexbezverkhniy.springcrm.common.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User class
 * 
 * @author "Alex Bezverkhniy"
 *
 */
@Entity
@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.username = ?1")
public class User extends AbstractPersistable<Long> {
    
	private static final long serialVersionUID = 5833255179194698922L;

	@Column(unique = true) 
	private String username;

    private String firstname;
    private String lastname;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<UserRole> roles;
    
	public User() {
		this(null);
	}
	
	public User(Long id) {
		this.setId(id);
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
    
    
}
