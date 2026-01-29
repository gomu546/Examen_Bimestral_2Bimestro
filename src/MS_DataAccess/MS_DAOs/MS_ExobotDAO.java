package MS_DataAccess.MS_DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MS_DataAccess.MS_DTOs.MS_ExobotDTO;
import MS_DataAccess.MS_Helpers.DataHelperSQLiteDAO;
import MS_Infrastructure.MS_AppConfig;
import MS_Infrastructure.MS_AppException;

public class MS_ExobotDAO extends DataHelperSQLiteDAO<MS_ExobotDTO> {
    public MS_ExobotDAO() throws MS_AppException {
        super(MS_ExobotDTO.class, "MS_Exobot", "IdExobot");
    }

    public boolean setEntreno(int idExobot) throws MS_AppException {
        String sql = "UPDATE MS_Exobot SET Entreno = 'SI' WHERE IdExobot = ?";
        try (PreparedStatement ps = openConnection().prepareStatement(sql)) {
            ps.setInt(1, idExobot);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new MS_AppException(null, e, getClass(), "setEntreno");
        }
    }

    public boolean setNoEntreno(int idExobot) throws MS_AppException {
        String sql = "UPDATE MS_Exobot SET Entreno = 'NO' WHERE IdExobot = ?";
        try (PreparedStatement ps = openConnection().prepareStatement(sql)) {
            ps.setInt(1, idExobot);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new MS_AppException(null, e, getClass(), "setNoEntreno");
        }
    }

    public boolean incrementarAccion(int idExobot) throws MS_AppException {
        String sql = "UPDATE MS_Exobot SET NoAccion = NoAccion + 1 WHERE IdExobot = ?";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MS_AppConfig.getDATABASE());
            conn.setAutoCommit(true);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idExobot);
                int resultado = ps.executeUpdate();
                return resultado > 0;
            }
        } catch (SQLException e) {
            throw new MS_AppException(null, e, getClass(), "incrementarAccion");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Obtiene todos los exobots con los datos detalados desde la vista
     */
    @Override
    public List<MS_ExobotDTO> readAll() throws MS_AppException {
        List<MS_ExobotDTO> list = new ArrayList<>();
        String sql = "SELECT IdExobot, Nombre, Serie, TipoExobot, Entreno, NoAccion, " +
                "ArmaDerecha, ArmaIzquierda FROM MS_vwExobotDetalle";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MS_ExobotDTO dto = new MS_ExobotDTO();
                dto.setIdExobot(rs.getInt("IdExobot"));
                dto.setNombre(rs.getString("Nombre"));
                dto.setSerie(rs.getString("Serie"));
                dto.setTipoExobot(rs.getString("TipoExobot"));
                dto.setEntreno(rs.getString("Entreno"));
                dto.setNoAccion(rs.getInt("NoAccion"));
                dto.setArmaDerecha(rs.getString("ArmaDerecha"));
                dto.setArmaIzquierda(rs.getString("ArmaIzquierda"));

                list.add(dto);
            }
        } catch (SQLException e) {
            throw new MS_AppException(null, e, getClass(), "readAll");
        }
        return list;
    }
}
