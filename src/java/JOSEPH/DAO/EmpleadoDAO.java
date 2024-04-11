package JOSEPH.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import JOSEPH.Dbase.ConexionDB;
import JOSEPH.VO.EmpleadoVO;

public class EmpleadoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public EmpleadoDAO() {
    }

    public void insertEmpleado(EmpleadoVO empleadoVO) {
        try {
            conn = ConexionDB.MYSQL();
            ps = conn.prepareStatement("INSERT INTO Empleados(nombre, cargo, telefono, salario) VALUES (?,?,?,?)");
            ps.setString(1, empleadoVO.getNombre());
            ps.setString(2, empleadoVO.getCargo());
            ps.setString(3, empleadoVO.getTelefono());
            ps.setBigDecimal(4, empleadoVO.getSalario());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error al insertar un Empleado!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EmpleadoVO findById(int empleado_id) {
        EmpleadoVO empleado = null;
        try {
            conn = ConexionDB.MYSQL();
            ps = conn.prepareStatement("SELECT * FROM Empleados WHERE empleado_id = ?");
            ps.setInt(1, empleado_id);
            rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new EmpleadoVO();
                empleado.setEmpleado_id(rs.getInt("empleado_id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setSalario(rs.getBigDecimal("salario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }
}
