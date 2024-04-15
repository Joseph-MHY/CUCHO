package JOSEPH.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import JOSEPH.Dbase.ConexionDB;
import JOSEPH.VO.DetallesVentaVO;
import JOSEPH.VO.VentaVO;

public class VentaDAO {
    private Connection conn;

    public VentaDAO() {
    }

    public void insertVenta(VentaVO ventavo) {
        try {
            conn = ConexionDB.MYSQL();

            // Convertir la lista de DetalleVenta a formato JSON
            String detallesVentaData = convertirAJSON(ventavo);

            PreparedStatement ps = conn.prepareStatement("{CALL RegistrarVenta(?,?,?)}");
            ps.setInt(1, ventavo.getCliente_id());
            ps.setInt(2, ventavo.getEmpleado_id());
            ps.setString(3, detallesVentaData);

            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para convertir la lista de DetalleVenta a formato JSON
    private String convertirAJSON(VentaVO ventavo) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (DetallesVentaVO detalle : ventavo.getDetalleVenta()) {
            json.append("{\"producto_id\": ").append(detalle.getProducto_id())
                .append(", \"cantidad\": ").append(detalle.getCantidad()).append("},");
        }
        // Eliminar la última coma
        if (!ventavo.getDetalleVenta().isEmpty()) {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("]");
        return json.toString();
    }
}
