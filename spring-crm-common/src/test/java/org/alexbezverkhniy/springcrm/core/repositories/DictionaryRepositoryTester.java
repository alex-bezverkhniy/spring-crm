package org.alexbezverkhniy.springcrm.core.repositories;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "/META-INF/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DictionaryRepositoryTester extends BaseDictionaryTester{

	@Test
	public void testFindByName() {		
		assertTrue(countryRepository.findByName(country.getName()).contains(country));
		assertTrue(regionRepository.findByName(region.getName()).contains(region));
		assertTrue(areaRepository.findByName(area.getName()).contains(area));
		assertTrue(cityRepository.findByName(city.getName()).contains(city));
		assertTrue(streetRepository.findByName(street.getName()).contains(street));
		assertTrue(houseRepository.findByName(house.getName()).contains(house));
	}

	@Test
	public void testFindByCode() {		
		assertTrue(country.equals(countryRepository.findByCode(country.getCode())) );
		assertTrue(region.equals(regionRepository.findByCode(region.getCode())) );
		assertTrue(area.equals(areaRepository.findByCode(area.getCode())) );
		assertTrue(city.equals(cityRepository.findByCode(city.getCode())) );
		assertTrue(street.equals(streetRepository.findByCode(street.getCode())) );
		assertTrue(house.equals(houseRepository.findByCode(house.getCode())) );
	}
}
