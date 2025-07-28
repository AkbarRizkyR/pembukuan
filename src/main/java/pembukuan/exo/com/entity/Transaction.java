package pembukuan.exo.com.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction extends PanacheEntity {
    public String deskripsi;
    public Double jumlah;
    public String tipe;
    public LocalDate tanggal;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
}
