package pembukuan.exo.com.dto;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class AdminUserDTO {

    @Schema(description = "Username admin", example = "admin1")
    public String username;

    @Schema(description = "Password admin", example = "123456")
    public String password;
}
