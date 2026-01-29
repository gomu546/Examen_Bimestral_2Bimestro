package MS_BusinessLogic.Entities;

public class MS_SoldadoExperto {
    private String nombre;
    private String tipoArma;

    public MS_SoldadoExperto(String nombre, String tipoArma) {
        this.nombre = nombre;
        this.tipoArma = tipoArma;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public String entrenar(MS_Arma arma) {
        arma.setEntrenada(true);
        return nombre + " " + tipoArma + " " + arma.getAccionArma();
    }

}
