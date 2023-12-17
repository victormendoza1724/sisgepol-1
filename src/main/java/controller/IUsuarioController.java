
package controller;
import java.util.Map;

public interface IUsuarioController {
    public String login(String correo, String contrasena);
    
    public String register(int id_Tabla, String nombres, String apellidos,String correo, String contrasena, String placa,
            String rol, String estado, String estacion, String grado);
    
    public String listar(boolean ordenar, String orden);
    
}
