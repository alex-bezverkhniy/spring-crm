package org.alexbezverkhniy.springcrm.core.repositories;

import org.alexbezverkhniy.springcrm.core.domain.dictionaries.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long>, BaseDictionaryRepository <Area, Long> {

}
