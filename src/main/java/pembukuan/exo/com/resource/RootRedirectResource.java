package pembukuan.exo.com.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

@Path("/")
public class RootRedirectResource {

    @GET

    public Response redirectToSwaggerUi() {
        return Response
                .temporaryRedirect(UriBuilder.fromUri("/pembukuan/swagger-ui").build())
                .build();
    }
}
