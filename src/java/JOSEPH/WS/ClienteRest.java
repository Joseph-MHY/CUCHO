package JOSEPH.WS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import JOSEPH.DAO.ClienteDAO;
import JOSEPH.VO.ClienteVO;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

@Path("cliente")
public class ClienteRest {

    @Context
    private UriInfo context;
    private ClienteDAO clienteDAO;

    public ClienteRest() {
        this.clienteDAO = new ClienteDAO();
    }

    @Path("/agregarCliente")
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response agregar(ClienteVO clienteVO){
        clienteDAO.insertCliente(clienteVO);
        return Response.ok().entity(clienteVO).build();
    }
}
