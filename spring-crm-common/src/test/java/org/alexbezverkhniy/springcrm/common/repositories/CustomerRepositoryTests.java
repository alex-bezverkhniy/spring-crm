package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "/META-INF/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepositoryTests {

	protected static Logger log = LoggerFactory
			.getLogger(CustomerRepositoryTests.class);

	@Autowired
    CustomerRepository customerRepository;
	@Autowired
    UserRoleRepository userRoleRepository;

	Customer customer;


	@Before
	public void setUp() {
		customer = new Customer();
		customer.setEmail("alexhustas@gmail.com");
		customer.setFirstName("Firstname");
		customer.setLastName("Lastname");
		


		customer = customerRepository.save(customer);
	}
	
	@After
	public void tearDown() throws Exception {

		customerRepository.delete(customer);
	}
	
	@Test
	public void findSavedUserById() {

		assertEquals(customer, customerRepository.findOne(customer.getId()));
	}

	@Test
	public void findSavedCustomerByLastname() throws Exception {

		List<Customer> customers = customerRepository.findByLastname("Lastname");

		assertNotNull(customers);
		log.info("SUTOMER: ");
		for (Customer customer : customers) {
			log.info("customer: " + customer.toString());
		}
		assertTrue(customers.contains(customer));
	}

	@Test
	public void findByFirstnameOrLastname() throws Exception {

		List<Customer> customers = customerRepository.findByFirstnameOrLastname("Lastname");

		assertTrue(customers.contains(customer));
	}






}
