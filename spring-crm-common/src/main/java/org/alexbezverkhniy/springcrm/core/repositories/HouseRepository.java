package org.alexbezverkhniy.springcrm.core.repositories;

import org.alexbezverkhniy.springcrm.core.domain.dictionaries.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends  JpaRepository<House, Long>, BaseDictionaryRepository <House, Long> {

}
