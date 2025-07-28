package pembukuan.exo.com.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import pembukuan.exo.com.dto.TransactionDTO;
import pembukuan.exo.com.entity.Transaction;
import pembukuan.exo.com.service.TransactionService;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {

    @Inject
    TransactionService service;

    @GET
    @Operation(summary = "Get all transactions")
    public List<Transaction> getAll() {
        return service.getAll();
    }

    @POST
    @Operation(summary = "Create transaction")
    public Response create(TransactionDTO dto) {
        Transaction t = service.create(dto);
        return t != null ? Response.ok(t).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update transaction")
    public Response update(@PathParam("id") Long id, TransactionDTO dto) {
        Transaction updated = service.update(id, dto);
        return updated != null ? Response.ok(updated).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete transaction")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = service.delete(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
