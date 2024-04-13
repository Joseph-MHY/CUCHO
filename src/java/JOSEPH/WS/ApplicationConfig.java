package JOSEPH.WS;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("wrs")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(JOSEPH.WS.CategoriaRest.class);
        resources.add(JOSEPH.WS.ClienteRest.class);
        resources.add(JOSEPH.WS.EmpleadoRest.class);
        resources.add(JOSEPH.WS.ProductoRest.class);
        resources.add(JOSEPH.WS.VentaRest.class);
    }
    
}
