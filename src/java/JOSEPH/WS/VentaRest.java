package JOSEPH.WS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import JOSEPH.CLASES.Venta;
import JOSEPH.DAO.VentaDAO;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("venta")
public class VentaRest {

    @Context
    private UriInfo context;
    private VentaDAO ventaDAO;

    public VentaRest() {
        this.ventaDAO = new VentaDAO();
    }

    @Path("/registrarVenta")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response registrar(Venta venta) {
        ventaDAO.insertVenta(venta);
        return Response.ok().entity(venta).build();
    }
}
