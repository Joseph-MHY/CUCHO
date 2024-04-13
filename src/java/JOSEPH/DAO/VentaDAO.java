package JOSEPH.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import JOSEPH.CLASES.DetalleVenta;
import JOSEPH.CLASES.Venta;
import JOSEPH.Dbase.ConexionDB;

public class VentaDAO {
    private Connection conn;

    public VentaDAO() {
    }

    public void insertVenta(Venta venta) {
        try {
            conn = ConexionDB.MYSQL();

            // Convertir la lista de DetalleVenta a formato JSON
            String detallesVentaData = convertirAJSON(venta);

            PreparedStatement ps = conn.prepareStatement("{CALL RegistrarVenta(?,?,?)}");
            ps.setInt(1, venta.getCliente_id());
            ps.setInt(2, venta.getEmpleado_id());
            ps.setString(3, detallesVentaData);

            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para convertir la lista de DetalleVenta a formato JSON
    private String convertirAJSON(Venta venta) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (DetalleVenta detalle : venta.getDetalleVenta()) {
            json.append("{\"producto_id\": ").append(detalle.getProducto_id())
                .append(", \"cantidad\": ").append(detalle.getCantidad()).append("},");
        }
        // Eliminar la última coma
        if (!venta.getDetalleVenta().isEmpty()) {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("]");
        return json.toString();
    }
}
