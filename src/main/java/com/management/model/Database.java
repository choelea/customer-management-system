package com.management.model;

/**
 * @ClassName : Database
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:45
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "databases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Database {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "database_name", nullable = false)
    private String databaseName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "port", nullable = false)
    private Integer port;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
}