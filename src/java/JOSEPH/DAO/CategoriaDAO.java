package JOSEPH.DAO;

import JOSEPH.Dbase.ConexionDB;
import JOSEPH.VO.CategoriaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoriaDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public CategoriaDAO() {
    }

    public CategoriaVO findById(int categoria_id) {
        CategoriaVO categoria = null;
        try {
            conn = ConexionDB.MYSQL();

            ps = conn.prepareStatement("SELECT * FROM Categorias WHERE categoria_id = ?");
            ps.setInt(1, categoria_id);

            rs = ps.executeQuery();

            if (rs.next()) {
                categoria = new CategoriaVO();
                categoria.setCategoria_id(rs.getInt("categoria_id"));
                categoria.setNombre("nombre");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }

    public void insertCategoria(CategoriaVO categoriaVO) {
        try {
            conn = ConexionDB.MYSQL();

            ps = conn.prepareStatement("INSERT INTO Categorias(nombre) VALUES (?)");
            ps.setString(1, categoriaVO.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCategoria(CategoriaVO categoriaVO) {
        try {
            conn = ConexionDB.MYSQL();

            ps = conn.prepareStatement("UPDATE Categorias SET nombre = ? WHERE categoria_id = ?");
            ps.setString(1, categoriaVO.getNombre());
            ps.setInt(2, categoriaVO.getCategoria_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
