package MS_BusinessLogic.Entities;

import MS_DataAccess.MS_DAOs.MS_ArmaDAO;
import MS_DataAccess.MS_DAOs.MS_ExobotDAO;
import MS_DataAccess.MS_DTOs.MS_ExobotDTO;
import MS_Infrastructure.MS_Tools.MS_CMD;
import MS_Infrastructure.MS_AppException;

public class MS_ExaBotBL {

    public void entrenarArma(int idExobot, int idArma, String tipoArma, String accionArma) throws MS_AppException {

        MS_ArmaDAO armaDAO = new MS_ArmaDAO();
        MS_ExobotDAO exobotDAO = new MS_ExobotDAO();

        boolean okArma = armaDAO.setEntrenada(idArma);

        if (!okArma) {
            MS_CMD.print("ERROR : No se pudo entrenar arma");
            return;
        }

        boolean okExobot = exobotDAO.setEntreno(idExobot);

        if (!okExobot) {
            MS_CMD.print("ERROR : No se pudo marcar Exobot entrenado");
            return;
        }

        MS_CMD.print("GOOD : SoldadoExperto " + tipoArma + " ENTRENADA");
    }

    public void accionArma(int idExobot, String extremidad) throws MS_AppException {

        MS_ExobotDAO exobotDAO = new MS_ExobotDAO();

        MS_ExobotDTO exobot = exobotDAO.readBy(idExobot);

        if (exobot == null) {
            MS_CMD.print("ERROR : Exobot no encontrado");
            return;
        }

        if (!"S".equalsIgnoreCase(exobot.getEntreno())) {
            MS_CMD.print("ERROR : Exobot NO_ENTRENADO");
            return;
        }

        String tipoArma;
        if ("DER".equalsIgnoreCase(extremidad)) {
            tipoArma = exobot.getArmaDerecha();
        } else {
            tipoArma = exobot.getArmaIzquierda();
        }

        if (tipoArma == null || tipoArma.isEmpty()) {
            MS_CMD.print("ERROR : Sin arma en " + extremidad);
            return;
        }

        exobotDAO.incrementarAccion(idExobot);

        MS_CMD.print("GOOD : " + tipoArma + " ACCION EJECUTADA");
    }
}
