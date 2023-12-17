
package beans;

public class Usuario {
    private int id_Tabla;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String placa;
    private String rol;
    private String estado;
    private String estacion;
    private String grado;

    public Usuario(int id_Tabla, String nombres, String apellidos, String correo, String contrasena, String placa, String rol, String estado, String estacion, String grado) {
        this.id_Tabla = id_Tabla;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.placa = placa;
        this.rol = rol;
        this.estado = estado;
        this.estacion = estacion;
        this.grado = grado;
    }
    
    public int getId() {
        return id_Tabla;
    }

    public void setId_Tabla(int id_Tabla) {
        this.id_Tabla = id_Tabla;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "usuario{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", contrasena=" + contrasena + ", placa=" + placa + ", rol=" + rol + ", estado=" + estado + ", estacion=" + estacion + ", grado=" + grado + '}';
    }
    
    
}
