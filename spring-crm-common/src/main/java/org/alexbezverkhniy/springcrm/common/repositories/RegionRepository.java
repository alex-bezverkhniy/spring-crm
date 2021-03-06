package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.dictionaries.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Region}} instances. Provides basic CRUD operations due to the extension of
 * {@link JpaRepository}. Includes custom implemented functionality by extending {@link BaseDictionaryRepository}.
 * 
 * @author Alexander Bezverkhniy
 *
 */
public interface RegionRepository extends JpaRepository<Region, Long>, BaseDictionaryRepository <Region, Long> {

}
