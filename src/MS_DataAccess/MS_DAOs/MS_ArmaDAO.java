package MS_DataAccess.MS_DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import MS_DataAccess.MS_DTOs.MS_ArmaDTO;
import MS_DataAccess.MS_Helpers.DataHelperSQLiteDAO;
import MS_Infrastructure.MS_AppException;

public class MS_ArmaDAO extends DataHelperSQLiteDAO<MS_ArmaDTO> {
    public MS_ArmaDAO() throws MS_AppException {
        super(MS_ArmaDTO.class, "MS_Arma", "IdArma");
    }

    public boolean setEntrenada(int idArma) throws MS_AppException {
        String sql = "UPDATE MS_Arma SET Entrenada = 1 WHERE IdArma = ?";
        try {
            PreparedStatement ps = openConnection().prepareStatement(sql);
            ps.setInt(1, idArma);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new MS_AppException(null, e, getClass(), "setEntrenada");
        }
    }
}
