package pembukuan.exo.com.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


public class AdminUserDTO {

    @Schema(description = "Username admin", example = "admin1")
    @NotBlank(message = "Username cannot be blank")
    public String username;

    @Schema(description = "Password admin", example = "StrongPass123!")
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$",
            message = "Password must contain at least one digit, one lowercase, one uppercase letter and one special character"
    )
    public String password;
}