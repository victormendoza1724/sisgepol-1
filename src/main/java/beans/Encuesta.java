/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;
 
import java.util.Date; 

public class Encuesta {
    private int id_Tabla;
    private int pregunta_1;
    private int pregunta_2;
    private int pregunta_3;
    private int pregunta_4;
    private int pregunta_5;
    private Date fecha;
    private int FK_Usuario;
    
    public Encuesta(int id_Tabla, int pregunta_1, int pregunta_2, int pregunta_3, int pregunta_4, int pregunta_5, Date fecha, int FK_Usuario) {
        this.id_Tabla = id_Tabla;
        this.pregunta_1 = pregunta_1;
        this.pregunta_2 = pregunta_2;
        this.pregunta_3 = pregunta_3;
        this.pregunta_4 = pregunta_4;
        this.pregunta_5 = pregunta_5;
        this.fecha = fecha;
        this.FK_Usuario = FK_Usuario;
    }


    public int getId_Tabla() {
        return id_Tabla;
    }

    public void setId_Tabla(int id_Tabla) {
        this.id_Tabla = id_Tabla;
    }

    public int getPregunta_1() {
        return pregunta_1;
    }

    public void setPregunta_1(int pregunta_1) {
        this.pregunta_1 = pregunta_1;
    }

    public int getPregunta_2() {
        return pregunta_2;
    }

    public void setPregunta_2(int pregunta_2) {
        this.pregunta_2 = pregunta_2;
    }

    public int getPregunta_3() {
        return pregunta_3;
    }

    public void setPregunta_3(int pregunta_3) {
        this.pregunta_3 = pregunta_3;
    }

    public int getPregunta_4() {
        return pregunta_4;
    }

    public void setPregunta_4(int pregunta_4) {
        this.pregunta_4 = pregunta_4;
    }

    public int getPregunta_5() {
        return pregunta_5;
    }

    public void setPregunta_5(int pregunta_5) {
        this.pregunta_5 = pregunta_5;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFK_Usuario() {
        return FK_Usuario;
    }

    public void setFK_Usuario(int FK_Usuario) {
        this.FK_Usuario = FK_Usuario;
    }

    @Override
    public String toString() {
        return "Encuesta{" + "id_Tabla=" + id_Tabla + ", pregunta_1=" + pregunta_1 + ", pregunta_2=" + pregunta_2 + ", pregunta_3=" + pregunta_3 + ", pregunta_4=" + pregunta_4 + ", pregunta_5=" + pregunta_5 + ", fecha=" + fecha + ", FK_Usuario=" + FK_Usuario + '}';
    }

}
