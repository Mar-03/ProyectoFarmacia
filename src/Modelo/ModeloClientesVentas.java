package Modelo;

/**
 *
 * @author jhosu
 */
public class ModeloClientesVentas {
    
    private int idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String nit;
    private String identificacion;
    private String telefono;
    private boolean tieneSubsidio;
    private Integer idInstitucionSubsidio; 

    public ModeloClientesVentas() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isTieneSubsidio() {
        return tieneSubsidio;
    }

    public void setTieneSubsidio(boolean tieneSubsidio) {
        this.tieneSubsidio = tieneSubsidio;
    }

    public Integer getIdInstitucionSubsidio() {
        return idInstitucionSubsidio;
    }

    public void setIdInstitucionSubsidio(Integer idInstitucionSubsidio) {
        this.idInstitucionSubsidio = idInstitucionSubsidio;
    }
    
    
    
    
}
