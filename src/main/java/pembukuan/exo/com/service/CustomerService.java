package pembukuan.exo.com.service;

import jakarta.inject.Inject;
import pembukuan.exo.com.dto.CustomerDTO;
import pembukuan.exo.com.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.transaction.Transactional;
import pembukuan.exo.com.repository.CustomerRepository;

import java.util.List;
import java.math.BigDecimal;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository repository;
    public List<Customer> getAll(String keyword) {
        if (keyword != null && !keyword.isBlank()) {
            return repository.searchByKeyword(keyword);
        } else {
            return repository.listAll();
        }
    }

    public Customer getById(Long id) {
        return Customer.findById(id);
    }

    @Transactional
    public Customer create(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.name = dto.name;
        customer.totalHutang = dto.totalHutang != null ? dto.totalHutang : BigDecimal.ZERO;
        customer.totalPesanan = dto.totalPesanan != null ? dto.totalPesanan : 0;
        customer.totalBayar = dto.totalBayar != null ? dto.totalBayar : BigDecimal.ZERO;
        customer.kiloPesanan = dto.kiloPesanan != null ? dto.kiloPesanan : BigDecimal.ZERO;
        customer.persist();
        return customer;
    }

    @Transactional
    public Customer update(Long id, CustomerDTO dto) {
        Customer customer = Customer.findById(id);
        if (customer == null) {
            throw new IllegalArgumentException("Customer tidak ditemukan");
        }

        if (dto.name != null) customer.name = dto.name;
        if (dto.totalHutang != null) customer.totalHutang = dto.totalHutang;
        if (dto.totalPesanan != null) customer.totalPesanan = dto.totalPesanan;
        if (dto.totalBayar != null) customer.totalBayar = dto.totalBayar;
        if (dto.kiloPesanan != null) customer.kiloPesanan = dto.kiloPesanan;

        return customer;
    }

    @Transactional
    public boolean delete(Long id) {
        return Customer.deleteById(id);
    }



}