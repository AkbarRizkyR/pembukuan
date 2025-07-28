package pembukuan.exo.com.service;

import pembukuan.exo.com.dto.AdminUserDTO;
import pembukuan.exo.com.entity.AdminUser;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class AdminUserService {

    public AdminUser create(AdminUserDTO dto) {
        AdminUser user = new AdminUser();
        user.username = dto.username;
        user.password = dto.password;
        user.persist();
        return user;
    }

    public AdminUser findByUsername(String username) {
        return AdminUser.find("username", username).firstResult();
    }

    public boolean login(String username, String password) {
        AdminUser user = findByUsername(username);
        return user != null && user.password.equals(password);
    }
}
