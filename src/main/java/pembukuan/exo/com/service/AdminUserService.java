package pembukuan.exo.com.service;

import pembukuan.exo.com.dto.AdminUserDTO;
import pembukuan.exo.com.entity.AdminUser;
import pembukuan.exo.com.repository.AdminUserRepository;
import pembukuan.exo.com.utils.JwtUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class AdminUserService {

    private static final List<String> COMMON_PASSWORDS = Arrays.asList(
            "password", "123456", "12345678", "1234", "qwerty",
            "12345", "dragon", "baseball", "football", "letmein"
    );

    @Inject
    AdminUserRepository adminUserRepository;

    @Inject
    JwtUtils jwtUtils;

    @Transactional(Transactional.TxType.REQUIRED)
    public AdminUser create(AdminUserDTO dto) {
        validatePasswordStrength(dto.password);

        if (adminUserRepository.existsByUsername(dto.username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        AdminUser user = new AdminUser();
        user.username = dto.username; // Akan dikonversi ke lowercase di hashPassword()
        user.password = dto.password;
        AdminUser.hashPassword(user); // Method ini juga mengkonversi username ke lowercase
        adminUserRepository.persist(user);
        return user;
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public AdminUser findByUsername(String username) {
        return adminUserRepository.findByUsername(username);
    }

    // No @Transactional needed for login as it's read-only
    public String login(String username, String password) {
        AdminUser user = findByUsername(username);
        if (user == null || !AdminUser.verifyPassword(password, user.password)) {
            return null;
        }
        return jwtUtils.generateToken(user.username);
    }

    private void validatePasswordStrength(String password) {
        if (COMMON_PASSWORDS.contains(password.toLowerCase())) {
            throw new IllegalArgumentException("Password is too common and easily guessable");
        }
    }
}