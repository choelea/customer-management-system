package com.management.controller;

/**
 * @ClassName : CustomerController
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:52
 */


import com.management.model.Customer;
import com.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAllCustomers());
        model.addAttribute("customer", new Customer());
        return "customers";
    }

    @GetMapping("/{id}/edit")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            model.addAttribute("editing", true);
            model.addAttribute("customers", customerService.findAllCustomers());
            return "customers";
        }
        return "redirect:/customers";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("successMessage", "Customer saved successfully.");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(id);
        redirectAttributes.addFlashAttribute("successMessage", "Customer deleted successfully.");
        return "redirect:/customers";
    }

    @GetMapping("/{id}/enable")
    public String enableCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.enableCustomer(id);
        if (customer != null) {
            redirectAttributes.addFlashAttribute("successMessage", "Customer enabled successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Customer not found.");
        }
        return "redirect:/customers";
    }

    @GetMapping("/{id}/disable")
    public String disableCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.disableCustomer(id);
        if (customer != null) {
            redirectAttributes.addFlashAttribute("successMessage", "Customer disabled successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Customer not found.");
        }
        return "redirect:/customers";
    }
}