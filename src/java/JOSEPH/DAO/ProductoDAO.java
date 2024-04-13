package JOSEPH.DAO;

import JOSEPH.Dbase.ConexionDB;
import JOSEPH.VO.ProductoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoDAO {
    private Connection conn;
    private PreparedStatement ps;

    public ProductoDAO() {
    }
    
    public void insertProduct(ProductoVO productoVO){
        try {
            conn = ConexionDB.MYSQL();
            
            ps = conn.prepareStatement("INSERT INTO Productos(nombre, categoria_id, precio, stock) VALUES (?,?,?,?)");
            ps.setString(1, productoVO.getNombre());
            ps.setInt(2, productoVO.getCategoria().getCategoria_id());
            ps.setBigDecimal(3, productoVO.getPrecio());
            ps.setInt(4, productoVO.getStock());
            
            int rows = ps.executeUpdate();
            if(rows != 1){
                throw new Exception("Error al insertar un Producto!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(ProductoVO productoVO){
        try {
            conn = ConexionDB.MYSQL();

            ps = conn.prepareStatement("UPDATE Productos SET nombre = ?, categoria_id = ?, precio = ?, stock = ? WHERE producto_id = ?");
            
            ps.setString(1, productoVO.getNombre());
            ps.setInt(2, productoVO.getCategoria().getCategoria_id());
            ps.setBigDecimal(3, productoVO.getPrecio());
            ps.setInt(4, productoVO.getStock());
            ps.setInt(5, productoVO.getProducto_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
