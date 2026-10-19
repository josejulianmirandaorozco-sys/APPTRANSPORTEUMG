package umg.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import umg.modelo.Camion;

public class CamionDAO {

    public boolean insertar(Camion c) {
        String sql = "INSERT INTO camion (matricula, modelo, tipo, potencia) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getMatricula());
            ps.setString(2, c.getModelo());
            ps.setString(3, c.getTipo());
            ps.setInt(4, c.getPotencia());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al insertar camión: " + ex.getMessage());
            return false;
        }
    }

    public List<Camion> listar() {
        List<Camion> lista = new ArrayList<>();
        String sql = "SELECT id_camion, matricula, modelo, tipo, potencia FROM camion";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Camion c = new Camion();
                c.setIdCamion(rs.getInt("id_camion"));
                c.setMatricula(rs.getString("matricula"));
                c.setModelo(rs.getString("modelo"));
                c.setTipo(rs.getString("tipo"));
                c.setPotencia(rs.getInt("potencia"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar camiones: " + ex.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Camion c) {
        String sql = "UPDATE camion SET matricula=?, modelo=?, tipo=?, potencia=? WHERE id_camion=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getMatricula());
            ps.setString(2, c.getModelo());
            ps.setString(3, c.getTipo());
            ps.setInt(4, c.getPotencia());
            ps.setInt(5, c.getIdCamion());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar camión: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idCamion) {
        String sql = "DELETE FROM camion WHERE id_camion=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCamion);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar camión: " + ex.getMessage());
            return false;
        }
    }
}