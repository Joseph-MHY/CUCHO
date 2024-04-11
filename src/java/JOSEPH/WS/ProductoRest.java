package JOSEPH.WS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import JOSEPH.DAO.ProductoDAO;
import JOSEPH.VO.ProductoVO;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;

@Path("producto")
public class ProductoRest {

    @Context
    private UriInfo context;
    private ProductoDAO productoDAO;

    public ProductoRest() {
        this.productoDAO = new ProductoDAO();
    }

    @Path("/agregarProducto")
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response agregar(ProductoVO producto) {
        productoDAO.insertProduct(producto);
        return Response.ok().entity(producto).build();
    }
}
