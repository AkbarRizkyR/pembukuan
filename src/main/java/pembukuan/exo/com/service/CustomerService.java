package pembukuan.exo.com.service;

import pembukuan.exo.com.dto.CustomerDTO;
import pembukuan.exo.com.entity.Customer;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    public List<Customer> getAll() {
        return Customer.listAll();
    }

    public Customer create(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.name = dto.name;
        customer.email = dto.email;
        customer.persist();
        return customer;
    }

    public Customer update(Long id, CustomerDTO dto) {
        Customer customer = Customer.findById(id);
        if (customer == null) return null;
        customer.name = dto.name;
        customer.email = dto.email;
        return customer;
    }

    public boolean delete(Long id) {
        return Customer.deleteById(id);
    }
}
