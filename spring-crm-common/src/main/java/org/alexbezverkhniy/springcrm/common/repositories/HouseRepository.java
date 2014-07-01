package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.dictionaries.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends  JpaRepository<House, Long>, BaseDictionaryRepository <House, Long> {

}
