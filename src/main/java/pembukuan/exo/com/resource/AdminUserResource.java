package pembukuan.exo.com.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import pembukuan.exo.com.dto.AdminUserDTO;
import pembukuan.exo.com.service.AdminUserService;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminUserResource {

    @Inject
    AdminUserService service;

    @POST
    @Path("/register")
    @Operation(summary = "Register Admin")
    public Response register(AdminUserDTO dto) {
        return Response.ok(service.create(dto)).build();
    }

    @POST
    @Path("/login")
    @Operation(summary = "Login Admin")
    public Response login(AdminUserDTO dto) {
        boolean success = service.login(dto.username, dto.password);
        if (success) {
            // Simulasi token
            String token = "fake-jwt-token-for-" + dto.username;
            return Response.ok().entity("{\"token\":\"" + token + "\"}").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
