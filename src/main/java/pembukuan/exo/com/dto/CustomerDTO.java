package pembukuan.exo.com.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import pembukuan.exo.com.entity.Customer;

public class CustomerDTO {
    @Schema(readOnly = true)
    public Long id;

    public String name;
    public BigDecimal totalHutang;
    public Integer totalPesanan;
    public BigDecimal totalBayar;
    public BigDecimal kiloPesanan;

    @Schema(readOnly = true)
    public LocalDateTime createdAt;

    @Schema(readOnly = true)
    public LocalDateTime updatedAt;


    // Mapping from Entity to DTO
    public static CustomerDTO fromEntity(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.id = customer.id;
        dto.name = customer.name;
        dto.totalHutang = customer.totalHutang;
        dto.totalPesanan = customer.totalPesanan;
        dto.totalBayar = customer.totalBayar;
        dto.kiloPesanan = customer.kiloPesanan;
        dto.createdAt = customer.createdAt;
        dto.updatedAt = customer.updatedAt;
        return dto;
    }

    // Mapping from DTO to Entity
    public Customer toEntity() {
        Customer customer = new Customer();
        customer.id = this.id; // Note: Only if updating
        customer.name = this.name;
        customer.totalHutang = this.totalHutang != null ? this.totalHutang : BigDecimal.ZERO;
        customer.totalPesanan = this.totalPesanan != null ? this.totalPesanan : 0;
        customer.totalBayar = this.totalBayar != null ? this.totalBayar : BigDecimal.ZERO;
        customer.kiloPesanan = this.kiloPesanan != null ? this.kiloPesanan : BigDecimal.ZERO;
        return customer;
    }
}
