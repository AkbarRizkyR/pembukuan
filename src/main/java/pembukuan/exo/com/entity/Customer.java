package pembukuan.exo.com.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class Customer extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    public Long id;

    @Column(nullable = false, length = 100)
    public String name;

    @Column(name = "total_hutang", precision = 12, scale = 2, nullable = false)
    public BigDecimal totalHutang = BigDecimal.ZERO;

    @Column(name = "total_pesanan", nullable = false)
    public Integer totalPesanan = 0;

    @Column(name = "total_bayar", precision = 12, scale = 2, nullable = false)
    public BigDecimal totalBayar = BigDecimal.ZERO;

    @Column(name = "kilo_pesanan", precision = 10, scale = 2, nullable = false)
    public BigDecimal kiloPesanan = BigDecimal.ZERO;

    @Column(name = "created_at", nullable = false, updatable = false)
    public LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    public LocalDateTime updatedAt;

    @PrePersist
    void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}