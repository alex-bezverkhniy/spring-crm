package org.alexbezverkhniy.springcrm.core.repositories;

import org.alexbezverkhniy.springcrm.core.domain.dictionaries.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long>, BaseDictionaryRepository <City, Long> {

}
