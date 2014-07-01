package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.dictionaries.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long>, BaseDictionaryRepository <City, Long> {

}
