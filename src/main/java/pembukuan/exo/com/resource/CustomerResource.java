package pembukuan.exo.com.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import pembukuan.exo.com.dto.CustomerDTO;
import pembukuan.exo.com.service.CustomerService;
import pembukuan.exo.com.entity.Customer;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService service;

    @GET
    @Operation(summary = "Get all customers")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @POST
    @Operation(summary = "Create customer")
    public Response create(CustomerDTO dto) {
        return Response.ok(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update customer")
    public Response update(@PathParam("id") Long id, CustomerDTO dto) {
        Customer updated = service.update(id, dto);
        if (updated == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete customer")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = service.delete(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
