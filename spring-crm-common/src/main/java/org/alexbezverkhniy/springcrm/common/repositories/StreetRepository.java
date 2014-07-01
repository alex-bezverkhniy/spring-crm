package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.dictionaries.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long>, BaseDictionaryRepository <Street, Long> {

}
