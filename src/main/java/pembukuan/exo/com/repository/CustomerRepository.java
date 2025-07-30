package pembukuan.exo.com.repository;

import pembukuan.exo.com.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

// CustomerRepository.java
@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> searchByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return listAll();
        }

        // Search case-insensitive di kolom 'name'
        return find("LOWER(name) LIKE LOWER(?1)", "%" + keyword + "%").list();
    }
}
