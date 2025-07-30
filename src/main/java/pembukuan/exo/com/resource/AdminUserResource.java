package pembukuan.exo.com.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import pembukuan.exo.com.dto.AdminUserDTO;
import pembukuan.exo.com.service.AdminUserService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
    @APIResponse(responseCode = "400", description = "Invalid input or weak password")
    @APIResponse(responseCode = "409", description = "Username already exists")
    public Response register(@Valid AdminUserDTO dto) {
        try {
            return Response.ok(service.create(dto)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"" + e.getMessage() + "\"}")
                    .build();
        }
    }

    @POST
    @Path("/login")
    @Operation(summary = "Login Admin")
    @APIResponse(responseCode = "401", description = "Invalid credentials")
    public Response login(@Valid AdminUserDTO dto) {
        String token = service.login(dto.username, dto.password);
        if (token != null) {
            return Response.ok().entity("{\"token\":\"" + token + "\"}").build();
        }
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"error\":\"Invalid username or password\"}")
                .build();
    }
}