package MS_DataAccess.MS_DTOs;

public class MS_TipoExobotDTO {
    private int IdTipoExobot;
    private String Nombre;

    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public int getIdTipoExobot() {
        return IdTipoExobot;
    }

    public void setIdTipoExobot(int idTipoExobot) {
        this.IdTipoExobot = idTipoExobot;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
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
