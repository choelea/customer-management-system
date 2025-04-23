package com.management.repository;

/**
 * @ClassName : DatabaseRepository
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:46
 */

import com.management.model.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<Database, Long> {
    // Add custom query methods if needed
}