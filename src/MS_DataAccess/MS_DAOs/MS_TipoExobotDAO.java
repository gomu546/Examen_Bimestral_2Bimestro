package MS_DataAccess.MS_DAOs;

import MS_DataAccess.MS_DTOs.MS_TipoExobotDTO;
import MS_DataAccess.MS_Helpers.DataHelperSQLiteDAO;
import MS_Infrastructure.MS_AppException;

public class MS_TipoExobotDAO extends DataHelperSQLiteDAO<MS_TipoExobotDTO> {
    public MS_TipoExobotDAO() throws MS_AppException {
        super(MS_TipoExobotDTO.class, "MS_TipoExobot", "IdTipoExobot");
    }
}
