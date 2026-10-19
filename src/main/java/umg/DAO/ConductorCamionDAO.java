package umg.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import umg.modelo.Camion;
import umg.modelo.Camionero;
import umg.modelo.ConductorCamion;

public class ConductorCamionDAO {

    public boolean insertar(ConductorCamion cc) {
        String sql = "INSERT INTO conductorcamion (idcamionero, idcamion, fecha) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cc.getConductor().getIdCamionero());
            ps.setInt(2, cc.getCamion().getIdCamion());
            ps.setDate(3, Date.valueOf(cc.getFecha()));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar conductor_camion: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(ConductorCamion cc) {
        String sql = "UPDATE conductorcamion SET idcamionero = ?, idcamion = ?, fecha = ? WHERE idconductorcamion = ?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cc.getConductor().getIdCamionero());
            ps.setInt(2, cc.getCamion().getIdCamion());
            ps.setDate(3, Date.valueOf(cc.getFecha()));
            ps.setInt(4, cc.getIdConductorCamion());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar conductor_camion: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM conductorcamion WHERE idconductorcamion = ?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar conductor_camion: " + e.getMessage());
            return false;
        }
    }

    public List<ConductorCamion> listar() {
    List<ConductorCamion> lista = new ArrayList<>();
    String sql = "SELECT cc.idconductorcamion, cc.idcamionero, cc.idcamion, cc.fecha, " +
                 "c.nombre AS nombre_camionero, cm.modelo, cm.matricula " +
                 "FROM conductorcamion cc " +
                 "INNER JOIN camionero c ON cc.idcamionero = c.idcamionero " +
                 "INNER JOIN camion cm ON cc.idcamion = cm.idcamion";

    try (Connection con = ConexionDB.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Camionero conductor = new Camionero();
            conductor.setIdCamionero(rs.getInt("idcamionero"));
            conductor.setNombre(rs.getString("nombre_camionero"));

            Camion camion = new Camion();
            camion.setIdCamion(rs.getInt("idcamion"));
            camion.setModelo(rs.getString("modelo"));
            camion.setMatricula(rs.getString("matricula"));

            ConductorCamion cc = new ConductorCamion();
            cc.setIdConductorCamion(rs.getInt("idconductorcamion"));
            cc.setConductor(conductor);
            cc.setCamion(camion);

            java.sql.Date f = rs.getDate("fecha");
            if (f != null) {
                cc.setFecha(f.toLocalDate());
            }

            lista.add(cc);
        }
    } catch (SQLException e) {
        System.err.println("Error al listar conductor_camion: " + e.getMessage());
    }
   return lista;
    }
}