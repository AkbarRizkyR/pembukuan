package pembukuan.exo.com.entity;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_user")
public class AdminUser extends PanacheEntity {

    @Column(nullable = false, unique = true)
    public String username; // Disimpan dalam lowercase

    @Column(nullable = false)
    public String password;

    public static void hashPassword(AdminUser user) {
        user.password = BcryptUtil.bcryptHash(user.password);
        user.username = user.username.toLowerCase(); // Konversi ke lowercase
    }

    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BcryptUtil.matches(plainPassword, hashedPassword);
    }
}