package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.dictionaries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long>, BaseDictionaryRepository<Country, Long> {
	
}
