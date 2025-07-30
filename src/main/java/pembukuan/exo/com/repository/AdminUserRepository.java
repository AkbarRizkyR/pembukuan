package pembukuan.exo.com.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import pembukuan.exo.com.entity.AdminUser;

@ApplicationScoped
public class AdminUserRepository implements PanacheRepository<AdminUser> {

    @Transactional
    public AdminUser findByUsername(String username) {
        return find("LOWER(username) = LOWER(?1)", username).firstResult();
    }

    @Transactional
    public boolean existsByUsername(String username) {
        return count("LOWER(username) = LOWER(?1)", username) > 0;
    }
}