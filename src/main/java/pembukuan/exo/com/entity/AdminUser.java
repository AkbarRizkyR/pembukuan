package pembukuan.exo.com.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_user")
public class AdminUser extends PanacheEntity {

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String password;
}
