package com.management.repository;

/**
 * @ClassName : CustomerRepository
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:45
 */


import com.management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Add custom query methods if needed
}
