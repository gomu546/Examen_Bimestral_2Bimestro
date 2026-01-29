package MS_BusinessLogic.Entities;

import MS_Infrastructure.MS_AppException;

public interface MS_IIAEXO {
    void accionArma(int idExobot, String extremidad) throws MS_AppException;
}
