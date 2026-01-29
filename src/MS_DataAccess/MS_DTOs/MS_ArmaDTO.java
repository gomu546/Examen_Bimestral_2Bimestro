package MS_DataAccess.MS_DTOs;

public class MS_ArmaDTO {
    private int IdArma;
    private String Tipo;
    private String Accion;
    private int Entrenada;

    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public int getIdArma() {
        return IdArma;
    }

    public void setIdArma(int idArma) {
        this.IdArma = idArma;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public String getAccion() {
        return Accion;
    }

    public void setAccion(String accion) {
        this.Accion = accion;
    }

    public int getEntrenada() {
        return Entrenada;
    }

    public void setEntrenada(int entrenada) {
        this.Entrenada = entrenada;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.FechaModifica = fechaModifica;
    }
}
