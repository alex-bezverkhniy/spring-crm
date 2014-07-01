package org.alexbezverkhniy.springcrm.common.repositories;

import java.util.List;

import org.alexbezverkhniy.springcrm.common.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {
	/*By ID*/
	@Query("SELECT a FROM Address a INNER JOIN a.house o where o.id = :id")
	List<Address> findByHouseId(@Param("id") String id);

	@Query("SELECT a FROM Address a INNER JOIN a.street o where o.id = :id")
	List<Address> findByStreetId(@Param("id") String id);

	@Query("SELECT a FROM Address a INNER JOIN a.city o where o.id = :id")
	List<Address> findByCityId(@Param("id") String id);
	
	@Query("SELECT a FROM Address a INNER JOIN a.area o where o.id = :id")
	List<Address> findByAreaId(@Param("id") String id);
	
	@Query("SELECT a FROM Address a INNER JOIN a.region o where o.id = :id")
	List<Address> findByRegionId(@Param("id") String id);
	
	@Query("SELECT a FROM Address a INNER JOIN a.country o where o.id = :id")
	List<Address> findByCountryId(@Param("id") String code);
	
	/*By CODE*/
	@Query("SELECT a FROM Address a INNER JOIN a.house o where o.code = :code")
	List<Address> findByHouseCode(@Param("code") String code);

	@Query("SELECT a FROM Address a INNER JOIN a.street o where o.code = :code")
	List<Address> findByStreetCode(@Param("code") String code);

	@Query("SELECT a FROM Address a INNER JOIN a.city o where o.code = :code")
	List<Address> findByCityCode(@Param("code") String code);
	
	@Query("SELECT a FROM Address a INNER JOIN a.area o where o.code = :code")
	List<Address> findByAreaCode(@Param("code") String code);
	
	@Query("SELECT a FROM Address a INNER JOIN a.region o where o.code = :code")
	List<Address> findByRegionCode(@Param("code") String code);
	
	@Query("SELECT a FROM Address a INNER JOIN a.country o where o.code = :code")
	List<Address> findByCountryCode(@Param("code") String code);
	
	/*By Name*/
	@Query("SELECT a FROM Address a INNER JOIN a.house o where o.name = :name")
	List<Address> findByHouseNumber(@Param("name") String name);

	@Query("SELECT a FROM Address a INNER JOIN a.street o where o.name = :name")
	List<Address> findByStreetName(@Param("name") String name);

	@Query("SELECT a FROM Address a INNER JOIN a.city o where o.name = :name")
	List<Address> findByCityName(@Param("name") String name);
	
	@Query("SELECT a FROM Address a INNER JOIN a.area o where o.name = :name")
	List<Address> findByAreaName(@Param("name") String name);
	
	@Query("SELECT a FROM Address a INNER JOIN a.region o where o.name = :name")
	List<Address> findByRegionName(@Param("name") String name);
	
	@Query("SELECT a FROM Address a INNER JOIN a.country o where o.name = :name")
	List<Address> findByCountryName(@Param("name") String name);

}
