package com.management.service;

/**
 * @ClassName : CustomerService
 * @Description :
 * @Author Franky
 * @Date 2025/4/22 21:46
 */

import com.management.model.Customer;
import com.management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * 查询所有客户，到期时间倒序排序
     * @return
     */
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        customers.sort((c1, c2) -> {
            if (c1.getExpirationDate() == null && c2.getExpirationDate() == null) {
                return 0;
            } else if (c1.getExpirationDate() == null) {
                return 1;
            } else if (c2.getExpirationDate() == null) {
                return -1;
            } else {
                return c2.getExpirationDate().compareTo(c1.getExpirationDate());
            }
        });
        return customers;
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer enableCustomer(Long id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setDisabled(false);
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer disableCustomer(Long id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setDisabled(true);
            return customerRepository.save(customer);
        }
        return null;
    }
}