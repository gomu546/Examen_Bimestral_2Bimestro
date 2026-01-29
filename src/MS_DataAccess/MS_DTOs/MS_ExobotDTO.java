package MS_DataAccess.MS_DTOs;

public class MS_ExobotDTO {

    private int IdExobot;
    private int IdTipoExobot;
    private int IdArmaDerecha;
    private int IdArmaIzquierda;

    private String Nombre;
    private String Serie;
    private String Entreno; // SI / NO
    private int NoAccion;

    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    // Campos de la vista (información denormalizada)
    private String TipoExobot;
    private String ArmaDerecha;
    private String ArmaIzquierda;

    public int getIdExobot() {
        return IdExobot;
    }

    public void setIdExobot(int idExobot) {
        this.IdExobot = idExobot;
    }

    public int getIdTipoExobot() {
        return IdTipoExobot;
    }

    public void setIdTipoExobot(int idTipoExobot) {
        this.IdTipoExobot = idTipoExobot;
    }

    public int getIdArmaDerecha() {
        return IdArmaDerecha;
    }

    public void setIdArmaDerecha(int idArmaDerecha) {
        this.IdArmaDerecha = idArmaDerecha;
    }

    public int getIdArmaIzquierda() {
        return IdArmaIzquierda;
    }

    public void setIdArmaIzquierda(int idArmaIzquierda) {
        this.IdArmaIzquierda = idArmaIzquierda;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        this.Serie = serie;
    }

    public String getEntreno() {
        return Entreno;
    }

    public void setEntreno(String entreno) {
        this.Entreno = entreno;
    }

    public int getNoAccion() {
        return NoAccion;
    }

    public void setNoAccion(int noAccion) {
        this.NoAccion = noAccion;
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

    public String getTipoExobot() {
        return TipoExobot;
    }

    public void setTipoExobot(String tipoExobot) {
        this.TipoExobot = tipoExobot;
    }

    public String getArmaDerecha() {
        return ArmaDerecha;
    }

    public void setArmaDerecha(String armaDerecha) {
        this.ArmaDerecha = armaDerecha;
    }

    public String getArmaIzquierda() {
        return ArmaIzquierda;
    }

    public void setArmaIzquierda(String armaIzquierda) {
        this.ArmaIzquierda = armaIzquierda;
    }
}
