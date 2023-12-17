
package controller;
import java.util.Map;
import java.util.Date;

public interface IEncuestaController {

    public String register(int id_Tabla, int pregunta_1,int pregunta_2,int pregunta_3,int pregunta_4,int pregunta_5,Date fecha,int FK_Usuario);
    public String listar(int FK_Usuario, String fecha_inicio, String fecha_fin);
    
}
