package com.management.model;

/**
 * @ClassName : Customer
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:45
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_database_name", nullable = false)
    private String customerDatabaseName;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "fee", nullable = false)
    private BigDecimal fee;

    @Column(name = "database_instance_name", nullable = false)
    private String databaseInstanceName;

    @Column(name = "disabled", nullable = false)
    private boolean disabled = false;
}