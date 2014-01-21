package org.alexbezverkhniy.springcrm.core.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.alexbezverkhniy.springcrm.core.domain.Address;
import org.alexbezverkhniy.springcrm.core.domain.AddressType;
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
public class AddressRepositoryTest extends BaseDictionaryTester{

	private Logger log = LoggerFactory.getLogger(AddressRepositoryTest.class);
	
	private Address address;
	
	@Autowired
	private AddressRepository addressRepository;	
	
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		address = new Address(house, street, city, area, region, country, new Date(), AddressType.LIVING);
		long id = addressRepository.save(address).getId();
		address = null;
		address = addressRepository.findOne(id);
	}

	@After
	@Override
	public void tearDown() throws Exception {
		addressRepository.delete(address);		
		super.tearDown();
	}

	@Test
	public void	findByStreetCode() {
		findBy(address, addressRepository.findByStreetCode(street.getCode()));

	}

	@Test
	public void	findByAreaCode() {
		List<Address> addresses = addressRepository.findByAreaCode(area.getCode());
		findBy(address, addresses);
	}

	private void findBy(Address address, List<Address> addresses) {
		log.info("findBy: " + address.getClass().getSimpleName());
		for (Address addr : addresses) {
			log.info("COMPARE : \n" + addr.toString() + "\nTO\n"
					+ address.toString());
		}
		assertTrue(addresses.contains(address));
		
	}
	
}
