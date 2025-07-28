package pembukuan.exo.com.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class CustomerDTO {

    @Schema(description = "Nama pelanggan", example = "Rizky")
    public String name;

    @Schema(description = "Email pelanggan", example = "rizky@email.com")
    public String email;
}
