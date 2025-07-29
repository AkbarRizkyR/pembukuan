package pembukuan.exo.com.resource;

import pembukuan.exo.com.dto.CustomerDTO;
import pembukuan.exo.com.entity.Customer;
import pembukuan.exo.com.service.CustomerService;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

@Tag(name = "Customer Resource", description = "Operations for customer management")
public class CustomerResource {

    @Inject
    CustomerService service;

    @GET
    @Path("/all")
    @Operation(summary = "Get all customers", description = "Returns list of all customers")
    public List<Customer> getAllCustomers() {
        return service.getAll();
    }

    @GET
    @Path("/detail/{id}")
    @Operation(summary = "Get customer by ID", description = "Retrieve single customer by their ID")
    public Response getCustomerById(@PathParam("id") Long id) {
        Customer customer = service.getById(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Customer with id " + id + " not found")
                    .build();
        }
        return Response.ok(customer).build();
    }

    @POST
    @Path("/create")
    @Operation(summary = "Create customer", description = "Create a new customer")
    public Response createCustomer(CustomerDTO dto) {
        if (dto.id != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("ID should not be provided for creation")
                    .build();
        }
        Customer created = service.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @POST
    @Path("/update/{id}")
    @Operation(summary = "Update customer using POST", description = "Update existing customer data by ID")
    public Response updateWithPost(@PathParam("id") Long id, CustomerDTO dto) {
        try {
            Customer updated = service.update(id, dto);
            return Response.ok(updated).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/delete/{id}")
    @Operation(summary = "Delete customer using POST", description = "Delete customer data by ID")
    public Response deleteWithPost(@PathParam("id") Long id) {
        boolean deleted = service.delete(id);
        return deleted
                ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND)
                .entity("Customer with id " + id + " not found")
                .build();
    }
}
