package com.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllDatabaseNames() {
        String sql = "SELECT name FROM sys.databases";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}