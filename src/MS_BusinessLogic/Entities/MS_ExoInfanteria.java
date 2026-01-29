package MS_BusinessLogic.Entities;

import MS_DataAccess.MS_DAOs.MS_ExobotDAO;
import MS_Infrastructure.MS_Tools.MS_CMD;
import MS_Infrastructure.MS_Tools.MS_ExoMunicion;
import MS_Infrastructure.MS_AppException;

public class MS_ExoInfanteria extends MS_ExaBot {

    public MS_ExoInfanteria(MS_Brazo der, MS_Brazo izq) {
        super(der, izq);
    }

    @Override
    public void accionArma(int idExobot, String extremidad) throws MS_AppException {

        MS_Arma arma = getArmaPorExtremidad(extremidad);

        if (arma == null) {
            MS_CMD.print("ERROR : ARMA NO DEFINIDA");
            return;
        }

        if (!arma.isEntrenada()) {
            MS_CMD.print(
                    "ERROR : " + arma.getTipoArma() + " " +
                            arma.getAccionArma() + " NO_ENTRENADA");
            return;
        }

        boolean hayMunicion = MS_ExoMunicion.hayMunicion(arma.getTipoArma());

        if (hayMunicion) {
            MS_CMD.print(
                    "GOOD : " + arma.getTipoArma() + " " +
                            arma.getAccionArma());

            MS_ExobotDAO dao = new MS_ExobotDAO();
            dao.incrementarAccion(idExobot);

        } else {
            MS_CMD.print(
                    "ERROR : " + arma.getTipoArma() + " " +
                            arma.getAccionArma() + " 0");
        }
    }

}
