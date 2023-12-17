package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController implements IUsuarioController {
    
    public String eliminar(int id_tabla){
     
        DBConnection con = new DBConnection();

        String sql = "DELETE FROM usuarios WHERE Id_tabla = " + id_tabla;

        try{
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            st.close();
            return "true";
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "false";
        }finally{
            con.desconectar();
        }
    }
    
    public String listar(boolean filtrar, int filtro){
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();

        String sql = "Select * From Usuarios where Rol <> 'Usuario' ";
        
        if  (filtrar == true)  {
            sql += " and id_tabla = " + filtro + " ";
        }
        
        sql += " order by nombres asc"; 
        
        List<String> usuarios = new ArrayList<>();
        
         try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                int id_Tabla = rs.getInt("id_Tabla");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                String contrasena = rs.getString("contrasena");
                String placa = rs.getString("placa");
                String estado = rs.getString("estado");
                String estacion = rs.getString("estacion");
                String grado = rs.getString("grado");
                
                
                Usuario usuario = new Usuario(id_Tabla, nombres, apellidos, correo, contrasena, placa, rol, estado, estacion, grado);
                usuarios.add(gson.toJson(usuario));
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
         
         return gson.toJson(usuarios);
    }

    @Override
    public String login(String correo, String contrasena){
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        
        String sql = "Select * From Usuarios where correo = '" + correo 
                + "' and contrasena = '" + contrasena + "'";
        
        try{
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                int id_Tabla = rs.getInt("id_Tabla");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String placa = rs.getString("placa");
                String rol = rs.getString("rol");
                String estado = rs.getString("estado");
                String estacion = rs.getString("estacion");
                String grado = rs.getString("grado");
                
                Usuario usuario = new Usuario(id_Tabla,nombres, apellidos, correo, contrasena, placa, rol, estado, estacion, grado);
                return gson.toJson(usuario);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            con.desconectar();
        }
        
        return "false";
    }
    
    @Override
    public String register(int id_Tabla, String nombres, String apellidos, String correo, String contrasena, 
            String placa, String rol, String estado, String estacion, String grado){
        
        Gson gson = new Gson();        
        DBConnection con = new DBConnection();

        String sql = "INSERT INTO usuarios(Nombres, Apellidos, Correo, Contrasena, Placa, Rol, Estado, Estacion, Grado)  VALUES ('" + nombres + "', '" + apellidos + "', '" + correo + "'," + "'" + contrasena + "', '" + placa + "', '" + rol + "', '" + estado + "', '" + estacion + "', '" + grado + "')";

        try{
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(id_Tabla, nombres, apellidos, correo, contrasena, placa, rol, estado, estacion, grado);
            
            st.close();
            return gson.toJson(usuario);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "false";
        }finally{
            con.desconectar();
        }
        
        
    }
    
    public String actualizar(int id_Tabla, String nombres, String apellidos, String correo, String contrasena, 
            String placa, String rol, String estado, String estacion, String grado){
        
        Gson gson = new Gson();        
        DBConnection con = new DBConnection();

        String sql = "Update usuarios set Nombres ='" + nombres + "', Apellidos= '" + apellidos + "', Correo = '" + correo + "', Contrasena = '" + contrasena + "', Placa = '" + placa + "', Rol = '" + rol + "', Estado = '" + estado + "', Estacion = '" + estacion + "', Grado = '" + grado + "' WHERE id_tabla = " + id_Tabla + " ";

        try{
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(id_Tabla, nombres, apellidos, correo, contrasena, placa, rol, estado, estacion, grado);
            
            st.close();
            return gson.toJson(usuario);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return "false";
        }finally{
            con.desconectar();
        }
        
        
    }

    @Override
    public String listar(boolean ordenar, String orden) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
