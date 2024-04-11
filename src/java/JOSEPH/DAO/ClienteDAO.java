package JOSEPH.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import JOSEPH.Dbase.ConexionDB;
import JOSEPH.VO.ClienteVO;

public class ClienteDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ClienteDAO() {
    }

    public void insertCliente(ClienteVO clienteVO) {
        try {
            conn = ConexionDB.MYSQL();
            ps = conn.prepareStatement("INSERT INTO Clientes(nombre, direccion, telefono) VALUES (?,?,?)");
            ps.setString(1, clienteVO.getNombre());
            ps.setString(2, clienteVO.getDireccion());
            ps.setString(3, clienteVO.getTelefono());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error al insertar un Cliente!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClienteVO findById(int cliente_id) {
        ClienteVO cliente = null;
        try {
            conn = ConexionDB.MYSQL();
            ps = conn.prepareStatement("SELECT * FROM Clientes WHERE cliente_id = ?");
            ps.setInt(1, cliente_id);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new ClienteVO();
                cliente.setCliente_id(rs.getInt("cliente_id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
