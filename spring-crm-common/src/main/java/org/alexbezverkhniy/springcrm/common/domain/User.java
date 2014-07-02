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
@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.userName = ?1")
public class User extends AbstractPersistable<Long> {
    
	private static final long serialVersionUID = 5833255179194698922L;

	@Column(unique = true) 
	private String userName;

    private String firstName;
    private String lastName;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<UserRole> roles;
    
	public User() {
		this(null);
	}
	
	public User(Long id) {
		this.setId(id);
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
    
    
}
