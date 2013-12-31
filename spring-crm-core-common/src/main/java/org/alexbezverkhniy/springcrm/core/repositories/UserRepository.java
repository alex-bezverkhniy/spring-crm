package org.alexbezverkhniy.springcrm.core.repositories;

import java.util.List;

import org.alexbezverkhniy.springcrm.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {//CrudRepository<User, Long> {
	
    @Query("select u from User u where u.username = ?")
    User findByUsername(String username);

	@Query("select u from User u where u.firstname = ?")
    List<User> findByFirstname(String firstname);

    @Query("select u from User u where u.lastname = ?")
    List<User> findByLastname(String lastname);

    @Query("select u from User u where u.firstname = :name or u.lastname = :name")
	List<User> findByFirstnameOrLastname(@Param("name") String name);

    @Query("SELECT u FROM User u INNER JOIN u.roles r where r.roleName = :name")
	List<User> findByRoleName(@Param("name") String name);

}
