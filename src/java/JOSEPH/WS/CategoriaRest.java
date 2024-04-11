package JOSEPH.WS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import JOSEPH.DAO.CategoriaDAO;
import JOSEPH.VO.CategoriaVO;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("categoria")
public class CategoriaRest {

    @Context
    private UriInfo context;
    private CategoriaDAO categoriaDAO;

    public CategoriaRest() {
        this.categoriaDAO = new CategoriaDAO();
    }

    @Path("/agregarCategoria")
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response agregar(CategoriaVO categoriaVO) {
        categoriaDAO.insertCategoria(categoriaVO);
        return Response.ok().entity(categoriaVO).build();
    }
}
