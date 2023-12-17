package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Encuesta;
import connection.DBConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


public class EncuestaController implements IEncuestaController {

    @Override
    public String listar(int id_user, String fecha_inicio, String fecha_fin) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * From encuestas where fecha BETWEEN '"+ fecha_inicio +"' and '"+ fecha_fin +"' ";
        System.out.println(sql);

        List<String> encuestas = new ArrayList<>();

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id_Tabla = rs.getInt("id_Tabla");
                int pregunta_1 = rs.getInt("pregunta_1");
                int pregunta_2 = rs.getInt("pregunta_2");
                int pregunta_3 = rs.getInt("pregunta_3");
                int pregunta_4 = rs.getInt("pregunta_4");
                int pregunta_5 = rs.getInt("pregunta_5");
                int FK_Usuario = rs.getInt("FK_Usuario");
                Date fecha = rs.getDate("fecha");

                Encuesta encuesta = new Encuesta(id_Tabla, pregunta_1, pregunta_2, pregunta_3, pregunta_4, pregunta_5, fecha, FK_Usuario);

                encuestas.add(gson.toJson(encuesta));
                
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "false";
        } finally {
            con.desconectar();
        }
        return gson.toJson(encuestas);
        
    }

    @Override
    public String register(int id_Tabla, int pregunta_1, int pregunta_2, int pregunta_3, int pregunta_4, int pregunta_5, Date fecha, int FK_Usuario) {

        Gson gson = new Gson();
        DBConnection con = new DBConnection();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fecha1 = formatter.format(fecha);

        String sql = "INSERT INTO encuestas(pregunta_1,pregunta_2,pregunta_3,pregunta_4,pregunta_5,fecha, FK_Usuario)  VALUES (" + pregunta_1 + "," + pregunta_2 + ", " + pregunta_3 + "," + pregunta_4 + ", " + pregunta_5 + ", '" + fecha1 + "', " + FK_Usuario + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Encuesta encuesta = new Encuesta(id_Tabla, pregunta_1, pregunta_2, pregunta_3, pregunta_4, pregunta_5, fecha, FK_Usuario);

            st.close();
            return gson.toJson(encuesta);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "false";
        } finally {
            con.desconectar();
        }

    }

}
