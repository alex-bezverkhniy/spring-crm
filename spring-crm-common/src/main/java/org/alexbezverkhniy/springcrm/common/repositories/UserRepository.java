package org.alexbezverkhniy.springcrm.common.repositories;

import java.util.List;

import org.alexbezverkhniy.springcrm.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {//CrudRepository<User, Long> {
	
    @Query("select u from User u where u.userName = ?")
    User findByUsername(String username);

	@Query("select u from User u where u.firstName = ?")
    List<User> findByFirstName(String firstname);

    @Query("select u from User u where u.lastName = ?")
    List<User> findByLastName(String lastname);

    @Query("select u from User u where u.firstName = :name or u.lastName = :name")
	List<User> findByFirstNameOrLastName(@Param("name") String name);

    @Query("SELECT u FROM User u INNER JOIN u.roles r where r.roleName = :name")
	List<User> findByRoleName(@Param("name") String name);

}
