// AdminUserRepository.java
package pembukuan.exo.com.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pembukuan.exo.com.entity.AdminUser;

@ApplicationScoped
public class AdminUserRepository implements PanacheRepository<AdminUser> {}
