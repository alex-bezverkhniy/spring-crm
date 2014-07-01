package org.alexbezverkhniy.springcrm.common.repositories;

import java.util.List;

import org.alexbezverkhniy.springcrm.common.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {//CrudRepository<User, Long> {
	
    @Query("select r from UserRole r where r.roleName = ?")
    List<UserRole> findByRoleName(String name);

}
