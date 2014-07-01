package org.alexbezverkhniy.springcrm.common.repositories;

import org.alexbezverkhniy.springcrm.common.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository for entities of "Customer" type
 *
 * Created by Alex Bezverkhniy
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select u from Customer u where u.email = ?")
    Customer findByEmail(String email);

    @Query("select u from Customer u where u.firstname = ?")
    List<Customer> findByFirstname(String firstname);

    @Query("select u from Customer u where u.lastname = ?")
    List<Customer> findByLastname(String lastname);

    @Query("select u from Customer u where u.firstname = :name or u.lastname = :name")
    List<Customer> findByFirstnameOrLastname(@Param("name") String name);

    @Query("select u from Customer u where u.mobilePhone = ?")
    Customer findByMobilePhone(String mobilePhone);

    @Query("select u from Customer u where u.workPhone = ?")
    Customer findByWorkPhone(String mobilePhone);

    @Query("select u from Customer u where u.homePhone = ?")
    Customer findByHomePhone(String homePhone);

    @Query("select u from Customer u where u.contactPhone = ?")
    Customer findByContactPhone(String contactPhone);
}
