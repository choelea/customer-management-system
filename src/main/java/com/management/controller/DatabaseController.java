package com.management.controller;

/**
 * @ClassName : DatabaseController
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:45
 */

import com.management.model.Database;
import com.management.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/databases")
public class DatabaseController {

    private final DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping
    public String listDatabases(Model model) {
        model.addAttribute("databases", databaseService.findAllDatabases());
        model.addAttribute("database", new Database());
        return "databases";
    }

    @GetMapping("/{id}/edit")
    public String editDatabaseForm(@PathVariable Long id, Model model) {
        Optional<Database> database = databaseService.findDatabaseById(id);
        if (database.isPresent()) {
            model.addAttribute("database", database.get());
            model.addAttribute("editing", true);
            model.addAttribute("databases", databaseService.findAllDatabases());
            return "databases";
        }
        return "redirect:/databases";
    }

    @PostMapping
    public String saveDatabase(@ModelAttribute Database database, RedirectAttributes redirectAttributes) {
        databaseService.saveDatabase(database);
        redirectAttributes.addFlashAttribute("successMessage", "Database saved successfully.");
        return "redirect:/databases";
    }

    @GetMapping("/{id}/delete")
    public String deleteDatabase(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        databaseService.deleteDatabase(id);
        redirectAttributes.addFlashAttribute("successMessage", "Database deleted successfully.");
        return "redirect:/databases";
    }
}