package org.alexbezverkhniy.springcrm.core.repositories;

import org.alexbezverkhniy.springcrm.core.domain.dictionaries.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long>, BaseDictionaryRepository <Street, Long> {

}
