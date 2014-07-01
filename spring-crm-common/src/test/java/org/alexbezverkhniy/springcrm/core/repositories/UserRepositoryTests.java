package org.alexbezverkhniy.springcrm.core.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.alexbezverkhniy.springcrm.core.domain.User;
import org.alexbezverkhniy.springcrm.core.domain.UserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "/META-INF/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTests {

	protected static Logger log = LoggerFactory
			.getLogger(UserRepositoryTests.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;

	User user;
	UserRole userRole;

	@Before
	public void setUp() {
		user = new User();
		user.setUsername("alexhustas");
		user.setFirstname("Firstname");
		user.setLastname("Lastname");
		
		userRole = new UserRole();
		userRole.setRoleName("user");
				
		List<UserRole> roles = new ArrayList<UserRole>();		
		roles.add(userRole);
		
		user.setRoles(roles);
		
		user = userRepository.save(user);				
	}
	
	@After
	public void tearDown() throws Exception {

		userRepository.delete(user);
		userRoleRepository.delete(user.getRoles());
	}
	
	@Test
	public void findSavedUserById() {

		assertEquals(user, userRepository.findOne(user.getId()));			
	}

	@Test
	public void findSavedUserByLastname() throws Exception {

		List<User> users = userRepository.findByLastname("Lastname");

		assertNotNull(users);
		log.info("USER: ");
		for (User user : users) {
			log.info("user: " + user.toString());
		}
		assertTrue(users.contains(user));
	}

	@Test
	public void findByFirstnameOrLastname() throws Exception {

		List<User> users = userRepository.findByFirstnameOrLastname("Lastname");

		assertTrue(users.contains(user));					
	}

	@Test
	public void findByRoleName() throws Exception {

		List<User> users = userRepository.findByRoleName("user");
		
		for (User user : users) {
			log.info("username: " + user.getUsername());
		}
		
		assertTrue(users.contains(user));					
	}


	@Test
	public void addRemoveRole() throws Exception {

		User user = userRepository.findByUsername(this.user.getUsername());
		
		assertNotNull(user.getRoles());

		// Add role
		UserRole role = new UserRole();
		role.setRoleName("admin");
		
		user.getRoles().add(role);

		user = userRepository.save(user);
		
		user = userRepository.findByUsername(this.user.getUsername());		
		log.info("user: " + user.toString());
		
		assertTrue(user.getRoles().size() == 2);
		for (UserRole ur : user.getRoles()) {
			log.info("user role: " + ur.getRoleName());
		}
		
		//Remove role
		role = user.getRoles().get(1); 
		user.getRoles().remove(1);
		user = userRepository.save(user);		
		userRoleRepository.delete(role);
		
		
		user = userRepository.findByUsername(this.user.getUsername());		
		log.info("user: " + user.toString());
		
		assertTrue(user.getRoles().size() == 1);
		for (UserRole ur : user.getRoles()) {
			log.info("user role: " + ur.getRoleName());
		}

		userRepository.delete(user);
		
	}


}
