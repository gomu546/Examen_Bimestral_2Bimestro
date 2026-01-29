//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package MS_BusinessLogic.Entities;

import MS_DataAccess.MS_DAOs.MS_ArmaDAO;
import MS_DataAccess.MS_DAOs.MS_ExobotDAO;
import MS_DataAccess.MS_DTOs.MS_ExobotDTO;
import MS_Infrastructure.MS_Tools.MS_CMD;
import MS_Infrastructure.MS_AppException;

/**
 * Servicio de lógica de negocio para ExaBot
 * Consolidación de operaciones de entrenamiento y acciones de armas
 */
public class ExaBotService {

    // ==============================
    // ENTRENAR ARMA
    // ==============================
    public void entrenarArma(int idExobot, int idArma, String tipoArma, String accionArma) throws MS_AppException {

        MS_ArmaDAO armaDAO = new MS_ArmaDAO();
        MS_ExobotDAO exobotDAO = new MS_ExobotDAO();

        // 1. Entrenar arma
        boolean okArma = armaDAO.setEntrenada(idArma);

        if (!okArma) {
            MS_CMD.print("ERROR : No se pudo entrenar arma");
            return;
        }

        // 2. Marcar exobot como entrenado
        boolean okExobot = exobotDAO.setEntreno(idExobot);

        if (!okExobot) {
            MS_CMD.print("ERROR : No se pudo marcar Exobot entrenado");
            return;
        }

        MS_CMD.print("GOOD : SoldadoExperto " + tipoArma + " ENTRENADA");
    }

    // ==============================
    // ACCIÓN ARMA
    // ==============================
    public void accionArma(int idExobot, String extremidad) throws MS_AppException {

        MS_ExobotDAO exobotDAO = new MS_ExobotDAO();

        // 1. Obtener datos del Exobot
        MS_ExobotDTO exobot = exobotDAO.readBy(idExobot);

        if (exobot == null) {
            MS_CMD.print("ERROR : Exobot no encontrado");
            return;
        }

        // 2. Validar entrenamiento
        if (!"SI".equalsIgnoreCase(exobot.getEntreno())) {
            MS_CMD.print("ERROR : Exobot NO_ENTRENADO");
            return;
        }

        // 3. Obtener arma por extremidad
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

        // 4. Incrementar número de acción
        exobotDAO.incrementarAccion(idExobot);

        // 5. Log correcto
        MS_CMD.print("GOOD : " + tipoArma + " ACCION EJECUTADA");
    }
}
