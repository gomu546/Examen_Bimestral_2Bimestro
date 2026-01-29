package MS_BusinessLogic.Entities;

import MS_Infrastructure.MS_Tools.MS_CMD;

public class MS_Arma {
    private String tipoArma;
    private String accionArma;
    private boolean entrenada;

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    public void setAccionArma(String accionArma) {
        this.accionArma = accionArma;
    }

    public void setEntrenada(boolean entrenada) {
        this.entrenada = entrenada;
    }

    public MS_Arma(String tipoArma, String accionArma) {
        this.tipoArma = tipoArma;
        this.accionArma = accionArma;
        this.entrenada = false;
    }

    public void entrenar(MS_SoldadoExperto soldado) {
        if (soldado.getTipoArma().equals(this.tipoArma)) {
            entrenada = true;
            MS_CMD.print("GOOD : " + soldado.getNombre() + " " + tipoArma + " " + accionArma);
        } else {
            MS_CMD.print("ERROR : " + soldado.getNombre() + " " + tipoArma + " " + accionArma);
        }
    }

    public boolean isEntrenada() {
        return entrenada;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public String getAccionArma() {
        return accionArma;
    }

}
