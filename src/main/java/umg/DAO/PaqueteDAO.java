package umg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import umg.modelo.Paquete;

public class PaqueteDAO {

    public List<Paquete> listar() {
        List<Paquete> lista = new ArrayList<>();
        String sql = "SELECT * FROM paquete";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paquete p = new Paquete();
                p.setIdPaquete(rs.getInt("id_paquete"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setDestinatario(rs.getString("destinatario"));
                p.setDireccionDestinatario(rs.getString("direccion_destinatario"));
                p.setIdCiudad(rs.getInt("idciudad"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar paquetes: " + e.getMessage());
        }
        return lista;
    }

    public boolean insertar(Paquete p) {
        String sql = "INSERT INTO paquete (codigo, descripcion, destinatario, direccion_destinatario, idciudad) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getDestinatario());
            ps.setString(4, p.getDireccionDestinatario());
            ps.setInt(5, p.getIdCiudad());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar paquete: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Paquete p) {
        String sql = "UPDATE paquete SET codigo=?, descripcion=?, destinatario=?, direccion_destinatario=?, idciudad=? WHERE id_paquete=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getDestinatario());
            ps.setString(4, p.getDireccionDestinatario());
            ps.setInt(5, p.getIdCiudad());
            ps.setInt(6, p.getIdPaquete());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar paquete: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idPaquete) {
        String sql = "DELETE FROM paquete WHERE id_paquete=?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPaquete);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar paquete: " + e.getMessage());
            return false;
        }
    }
}