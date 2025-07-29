package pembukuan.exo.com.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;

@Schema(description = "Data transfer object untuk Customer")
public class CustomerDTO {

    @Schema(description = "ID unik customer", example = "4e2494e3-bf71-4c8e-91ff-f8efb4f0e3a3")
    public UUID id;

    @Schema(description = "Nama lengkap customer", example = "Akbar Rizky Rabbani", required = true)
    @NotBlank(message = "Nama customer tidak boleh kosong")
    public String name;

    @Schema(description = "Total hutang customer", example = "150000.00")
    public BigDecimal totalHutang = BigDecimal.ZERO;

    @Schema(description = "Total jumlah pesanan customer", example = "5")
    public Integer totalPesanan = 0;

    @Schema(description = "Total pembayaran yang sudah dilakukan", example = "100000.00")
    public BigDecimal totalBayar = BigDecimal.ZERO;

    @Schema(description = "Total berat pesanan dalam kg", example = "12.5")
    public BigDecimal kiloPesanan = BigDecimal.ZERO;

    @Schema(description = "Waktu dibuat", example = "2024-07-29T13:45:00")
    public String createdAt;

    @Schema(description = "Waktu terakhir diubah", example = "2024-08-01T09:00:00")
    public String updatedAt;

    public CustomerDTO() {
        // default constructor
    }

    public CustomerDTO(String name,
                       BigDecimal totalHutang,
                       Integer totalPesanan,
                       BigDecimal totalBayar,
                       BigDecimal kiloPesanan) {
        this.name = name;
        this.totalHutang = totalHutang != null ? totalHutang : BigDecimal.ZERO;
        this.totalPesanan = totalPesanan != null ? totalPesanan : 0;
        this.totalBayar = totalBayar != null ? totalBayar : BigDecimal.ZERO;
        this.kiloPesanan = kiloPesanan != null ? kiloPesanan : BigDecimal.ZERO;
    }
}
