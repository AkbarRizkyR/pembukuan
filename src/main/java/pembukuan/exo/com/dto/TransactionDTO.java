package pembukuan.exo.com.dto;



import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

public class TransactionDTO {

    @Schema(description = "Deskripsi transaksi", example = "Pembayaran Tagihan")
    public String deskripsi;

    @Schema(description = "Jumlah transaksi", example = "150000")
    public Double jumlah;

    @Schema(description = "Jenis transaksi", example = "PENGELUARAN")
    public String tipe;

    @Schema(description = "Tanggal transaksi", example = "2025-07-27")
    public LocalDate tanggal;

    @Schema(description = "ID Customer", example = "1")
    public Long customerId;
}
