package JOSEPH.WS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import JOSEPH.DAO.EmpleadoDAO;
import JOSEPH.VO.EmpleadoVO;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

@Path("empleado")
public class EmpleadoRest {

    @Context
    private UriInfo context;
    private EmpleadoDAO empleadoDAO;

    public EmpleadoRest() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    @Path("/agregarEmpleado")
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response agregar(EmpleadoVO empleadoVO) {
        empleadoDAO.insertEmpleado(empleadoVO);
        return Response.ok().entity(empleadoVO).build();
    }
}
