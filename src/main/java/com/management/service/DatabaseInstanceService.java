package com.management.service;

/**
 * @ClassName : DatabaseService
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:46
 */
import com.management.model.Database;
import com.management.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseInstanceService {

    private final DatabaseRepository databaseRepository;

    @Autowired
    public DatabaseInstanceService(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public List<Database> findAllDatabases() {
        return databaseRepository.findAll();
    }

    public Optional<Database> findDatabaseById(Long id) {
        return databaseRepository.findById(id);
    }

    public Database saveDatabase(Database database) {
        return databaseRepository.save(database);
    }

    public void deleteDatabase(Long id) {
        databaseRepository.deleteById(id);
    }
}