package org.alexbezverkhniy.springcrm.core.repositories;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.alexbezverkhniy.springcrm.core.domain.Address;
import org.alexbezverkhniy.springcrm.core.domain.BaseEntity;
import org.alexbezverkhniy.springcrm.core.domain.dictionaries.Area;
import org.alexbezverkhniy.springcrm.core.domain.dictionaries.City;
import org.alexbezverkhniy.springcrm.core.domain.dictionaries.Country;
import org.alexbezverkhniy.springcrm.core.domain.dictionaries.House;
import org.alexbezverkhniy.springcrm.core.domain.dictionaries.Region;
import org.alexbezverkhniy.springcrm.core.domain.dictionaries.Street;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDictionaryTester {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected Country country;
	protected Region region;
	protected Area area;
	protected City city;
	protected Street street;
	protected House house;
	

	@Autowired
	protected CountryRepository countryRepository;
	
	@Autowired
	protected RegionRepository regionRepository;
	
	@Autowired
	protected AreaRepository areaRepository; 

	@Autowired
	protected CityRepository cityRepository;

	@Autowired
	protected StreetRepository streetRepository;

	@Autowired
	protected HouseRepository houseRepository;

	@Before
	public void setUp() throws Exception {
		country = new Country("KAZ", "Kazakhstan");
		country = countryRepository.save(country);
		
		region = new Region("SOUTH_REG", "Region of south", country);
		region = regionRepository.save(region);
		
		area = new Area("ALMATY_ARE", "Area of Almaty", region);
		area = areaRepository.save(area);
		
		city = new City("ALM_CIT", "Almaty", area);
		city = cityRepository.save(city);
		
		street = new Street("ABAY_STR", "Abay str", city);
		street = streetRepository.save(street);
		
		house = new House(UUID.randomUUID().toString(), "63", street);
		house = houseRepository.save(house);
	}

	@After
	public void tearDown() throws Exception {
		houseRepository.delete(house);
		streetRepository.delete(street);
		cityRepository.delete(city);
		areaRepository.delete(area);		
		regionRepository.delete(region);
		countryRepository.delete(country);		
	}
		
}
