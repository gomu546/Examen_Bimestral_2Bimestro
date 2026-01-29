package MS_BusinessLogic.Entities;

import MS_Infrastructure.MS_AppException;

public class MS_ExaBot extends MS_IAEXO {

    protected MS_Brazo brazoDerecho;
    protected MS_Brazo brazoIzquierdo;

    public MS_ExaBot(MS_Brazo der, MS_Brazo izq) {
        this.brazoDerecho = der;
        this.brazoIzquierdo = izq;
    }

    public void entrenarArma(MS_SoldadoExperto soldado, boolean derecho) {
        if (derecho) {
            brazoDerecho.getArma().entrenar(soldado);
        } else {
            brazoIzquierdo.getArma().entrenar(soldado);
        }
    }

    public MS_Arma getArmaPorExtremidad(String extremidad) {
        if ("DER".equalsIgnoreCase(extremidad)) {
            return brazoDerecho.getArma();
        }
        return brazoIzquierdo.getArma();
    }

    @Override
    public void accionArma(int idExobot, String extremidad) throws MS_AppException {

        throw new UnsupportedOperationException("Unimplemented method 'accionArma'");
    }
}
