package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.Customer;
import org.alexbezverkhniy.springcrm.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository for entities of "Customer" type
 *
 * Created by Alex Bezverkhniy
 */
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select u from Customer u where u.email = ?")
    Customer findByEmail(String email);

    @Query("select u from Customer u where u.firstName = ?")
    List<Customer> findByFirstName(String firstName);

    @Query("select u from Customer u where u.lastName = ?")
    List<Customer> findByLastName(String lastName);

    @Query("select u from Customer u where u.firstName = :name or u.lastName = :name")
    List<Customer> findByFirstNameOrLastName(@Param("name") String name);

    @Query("select u from Customer u where u.mobilePhone = ?")
    Customer findByMobilePhone(String mobilePhone);

    @Query("select u from Customer u where u.workPhone = ?")
    Customer findByWorkPhone(String mobilePhone);

    @Query("select u from Customer u where u.homePhone = ?")
    Customer findByHomePhone(String homePhone);

    @Query("select u from Customer u where u.contactPhone = ?")
    Customer findByContactPhone(String contactPhone);

}
